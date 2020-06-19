package topology;

import com.google.protobuf.InvalidProtocolBufferException;
import generator.Company;
import generator.Filter;
import generator.Operator;
import generator.Publication;
import javafx.util.Pair;
import messages.CompanyProto;
import messages.PublicationProto;
import messages.SubscriptionProto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProtoSerializer {

    public static List<Byte> serializePublication(Publication publication) {

        if (publication == null) {
            return null;
        }

        byte[] serializedPublication = PublicationProto.Publication.newBuilder().
                setCompany(CompanyProto.Company.valueOf(publication.getCompany().getCompanyName())).
                setStockValue(publication.getStockValue()).
                setChange(publication.getChange()).
                setVariation(publication.getVariation()).
                setDate(publication.getDate().getTime())
                .build().toByteArray();

        return convertByteArrayToByteList(serializedPublication);
    }

    public static Publication deserializePublication(List<Byte> bytes) {
        if (bytes == null) {
            return null;
        }
        try {
            PublicationProto.Publication protoPublication = PublicationProto.Publication.parseFrom(convertByteListToByteArray(bytes));

            Company company = Company.values()[protoPublication.getCompany().getNumber()];
            double stockValue = protoPublication.getStockValue();
            double change = protoPublication.getChange();
            Date date = new Date(protoPublication.getDate());

            return new Publication(company, stockValue, change, date);

        } catch (InvalidProtocolBufferException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Byte> serializeSubscription(List<Filter> filters, String subscriberId) {
        if (filters == null || subscriberId == null) {
            return null;
        }
        List<SubscriptionProto.Subscription.Filter> protoFilters = new ArrayList<>();

        for (Filter filter : filters) {
            SubscriptionProto.Subscription.Filter.Builder builder = SubscriptionProto.Subscription.Filter.newBuilder().
                    setFieldName(filter.getFieldName()).
                    setOperator(SubscriptionProto.Subscription.Filter.Operator.valueOf(filter.getOperator().getOperatorName()));

            switch (filter.getFieldName()) {
                case "company": {
                    builder.setCompany(CompanyProto.Company.valueOf(((Company) filter.getValue()).getCompanyName()));
                    break;
                }
                case "stockValue": {
                    builder.setStockValue((Double) filter.getValue());
                    break;
                }
                case "change": {
                    builder.setChange((Double) filter.getValue());
                    break;
                }
                case "variation": {
                    builder.setVariation((Double) filter.getValue());
                    break;
                }
                case "date": {
                    builder.setDate(((Date) filter.getValue()).getTime());
                    break;
                }
                default: {
                    break;
                }
            }
            protoFilters.add(builder.build());
        }

        byte[] serializedSubscription = SubscriptionProto.Subscription.newBuilder().
                setSubscriberId(subscriberId).
                addAllFilters(protoFilters).
                build().toByteArray();

        return convertByteArrayToByteList(serializedSubscription);
    }

    public static Pair<String, List<Filter>> deserializeSubscription(List<Byte> bytes) {
        if (bytes == null) {
            return new Pair<>(null, null);
        }
        try {
            SubscriptionProto.Subscription sub = SubscriptionProto.Subscription.parseFrom(convertByteListToByteArray(bytes));
            String subscriberId = sub.getSubscriberId();

            List<Filter> filters = new ArrayList<>();

            for (SubscriptionProto.Subscription.Filter protoFilter : sub.getFiltersList()) {
                Operator operator = Operator.values()[protoFilter.getOperator().getNumber()];
                String fieldName = protoFilter.getFieldName();
                Object value = null;

                switch (fieldName) {
                    case "company": {
                        value = Company.values()[protoFilter.getCompany().getNumber()];
                        break;
                    }
                    case "stockValue": {
                        value = protoFilter.getStockValue();
                        break;
                    }
                    case "change": {
                        value = protoFilter.getChange();
                        break;
                    }
                    case "variation": {
                        value = protoFilter.getVariation();
                        break;
                    }
                    case "date": {
                        value = new Date(protoFilter.getDate());
                        break;
                    }
                    default: {
                        break;
                    }

                }
                filters.add(new Filter(operator, value, fieldName));
            }

            return new Pair<>(subscriberId, filters);

        } catch (InvalidProtocolBufferException e) {
            throw new RuntimeException(e);
        }
    }

    private static byte[] convertByteListToByteArray(List<Byte> bytes) {
        byte[] result = new byte[bytes.size()];

        for (int i = 0; i < bytes.size(); i++) {
            result[i] = bytes.get(i);
        }

        return result;
    }

    private static List<Byte> convertByteArrayToByteList(byte[] bytes) {

        List<Byte> result = new ArrayList<>();

        for (byte b : bytes) {
            result.add(b);
        }
        return result;
    }
}
