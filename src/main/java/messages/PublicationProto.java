// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: publication.proto

package messages;

public final class PublicationProto {
  private PublicationProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface PublicationOrBuilder extends
      // @@protoc_insertion_point(interface_extends:stocks.Publication)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>.stocks.Company company = 1;</code>
     * @return The enum numeric value on the wire for company.
     */
    int getCompanyValue();
    /**
     * <code>.stocks.Company company = 1;</code>
     * @return The company.
     */
    messages.CompanyProto.Company getCompany();

    /**
     * <code>double stock_value = 2;</code>
     * @return The stockValue.
     */
    double getStockValue();

    /**
     * <code>double change = 3;</code>
     * @return The change.
     */
    double getChange();

    /**
     * <code>double variation = 4;</code>
     * @return The variation.
     */
    double getVariation();

    /**
     * <code>int64 date = 5;</code>
     * @return The date.
     */
    long getDate();
  }
  /**
   * Protobuf type {@code stocks.Publication}
   */
  public static final class Publication extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:stocks.Publication)
      PublicationOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use Publication.newBuilder() to construct.
    private Publication(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Publication() {
      company_ = 0;
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new Publication();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private Publication(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 8: {
              int rawValue = input.readEnum();

              company_ = rawValue;
              break;
            }
            case 17: {

              stockValue_ = input.readDouble();
              break;
            }
            case 25: {

              change_ = input.readDouble();
              break;
            }
            case 33: {

              variation_ = input.readDouble();
              break;
            }
            case 40: {

              date_ = input.readInt64();
              break;
            }
            default: {
              if (!parseUnknownField(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return messages.PublicationProto.internal_static_stocks_Publication_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return messages.PublicationProto.internal_static_stocks_Publication_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              messages.PublicationProto.Publication.class, messages.PublicationProto.Publication.Builder.class);
    }

    public static final int COMPANY_FIELD_NUMBER = 1;
    private int company_;
    /**
     * <code>.stocks.Company company = 1;</code>
     * @return The enum numeric value on the wire for company.
     */
    @java.lang.Override public int getCompanyValue() {
      return company_;
    }
    /**
     * <code>.stocks.Company company = 1;</code>
     * @return The company.
     */
    @java.lang.Override public messages.CompanyProto.Company getCompany() {
      @SuppressWarnings("deprecation")
      messages.CompanyProto.Company result = messages.CompanyProto.Company.valueOf(company_);
      return result == null ? messages.CompanyProto.Company.UNRECOGNIZED : result;
    }

    public static final int STOCK_VALUE_FIELD_NUMBER = 2;
    private double stockValue_;
    /**
     * <code>double stock_value = 2;</code>
     * @return The stockValue.
     */
    @java.lang.Override
    public double getStockValue() {
      return stockValue_;
    }

    public static final int CHANGE_FIELD_NUMBER = 3;
    private double change_;
    /**
     * <code>double change = 3;</code>
     * @return The change.
     */
    @java.lang.Override
    public double getChange() {
      return change_;
    }

    public static final int VARIATION_FIELD_NUMBER = 4;
    private double variation_;
    /**
     * <code>double variation = 4;</code>
     * @return The variation.
     */
    @java.lang.Override
    public double getVariation() {
      return variation_;
    }

    public static final int DATE_FIELD_NUMBER = 5;
    private long date_;
    /**
     * <code>int64 date = 5;</code>
     * @return The date.
     */
    @java.lang.Override
    public long getDate() {
      return date_;
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (company_ != messages.CompanyProto.Company.GOOGLE.getNumber()) {
        output.writeEnum(1, company_);
      }
      if (stockValue_ != 0D) {
        output.writeDouble(2, stockValue_);
      }
      if (change_ != 0D) {
        output.writeDouble(3, change_);
      }
      if (variation_ != 0D) {
        output.writeDouble(4, variation_);
      }
      if (date_ != 0L) {
        output.writeInt64(5, date_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (company_ != messages.CompanyProto.Company.GOOGLE.getNumber()) {
        size += com.google.protobuf.CodedOutputStream
          .computeEnumSize(1, company_);
      }
      if (stockValue_ != 0D) {
        size += com.google.protobuf.CodedOutputStream
          .computeDoubleSize(2, stockValue_);
      }
      if (change_ != 0D) {
        size += com.google.protobuf.CodedOutputStream
          .computeDoubleSize(3, change_);
      }
      if (variation_ != 0D) {
        size += com.google.protobuf.CodedOutputStream
          .computeDoubleSize(4, variation_);
      }
      if (date_ != 0L) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(5, date_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof messages.PublicationProto.Publication)) {
        return super.equals(obj);
      }
      messages.PublicationProto.Publication other = (messages.PublicationProto.Publication) obj;

      if (company_ != other.company_) return false;
      if (java.lang.Double.doubleToLongBits(getStockValue())
          != java.lang.Double.doubleToLongBits(
              other.getStockValue())) return false;
      if (java.lang.Double.doubleToLongBits(getChange())
          != java.lang.Double.doubleToLongBits(
              other.getChange())) return false;
      if (java.lang.Double.doubleToLongBits(getVariation())
          != java.lang.Double.doubleToLongBits(
              other.getVariation())) return false;
      if (getDate()
          != other.getDate()) return false;
      if (!unknownFields.equals(other.unknownFields)) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + COMPANY_FIELD_NUMBER;
      hash = (53 * hash) + company_;
      hash = (37 * hash) + STOCK_VALUE_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          java.lang.Double.doubleToLongBits(getStockValue()));
      hash = (37 * hash) + CHANGE_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          java.lang.Double.doubleToLongBits(getChange()));
      hash = (37 * hash) + VARIATION_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          java.lang.Double.doubleToLongBits(getVariation()));
      hash = (37 * hash) + DATE_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getDate());
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static messages.PublicationProto.Publication parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static messages.PublicationProto.Publication parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static messages.PublicationProto.Publication parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static messages.PublicationProto.Publication parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static messages.PublicationProto.Publication parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static messages.PublicationProto.Publication parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static messages.PublicationProto.Publication parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static messages.PublicationProto.Publication parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static messages.PublicationProto.Publication parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static messages.PublicationProto.Publication parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static messages.PublicationProto.Publication parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static messages.PublicationProto.Publication parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(messages.PublicationProto.Publication prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code stocks.Publication}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:stocks.Publication)
        messages.PublicationProto.PublicationOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return messages.PublicationProto.internal_static_stocks_Publication_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return messages.PublicationProto.internal_static_stocks_Publication_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                messages.PublicationProto.Publication.class, messages.PublicationProto.Publication.Builder.class);
      }

      // Construct using messages.PublicationProto.Publication.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        company_ = 0;

        stockValue_ = 0D;

        change_ = 0D;

        variation_ = 0D;

        date_ = 0L;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return messages.PublicationProto.internal_static_stocks_Publication_descriptor;
      }

      @java.lang.Override
      public messages.PublicationProto.Publication getDefaultInstanceForType() {
        return messages.PublicationProto.Publication.getDefaultInstance();
      }

      @java.lang.Override
      public messages.PublicationProto.Publication build() {
        messages.PublicationProto.Publication result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public messages.PublicationProto.Publication buildPartial() {
        messages.PublicationProto.Publication result = new messages.PublicationProto.Publication(this);
        result.company_ = company_;
        result.stockValue_ = stockValue_;
        result.change_ = change_;
        result.variation_ = variation_;
        result.date_ = date_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof messages.PublicationProto.Publication) {
          return mergeFrom((messages.PublicationProto.Publication)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(messages.PublicationProto.Publication other) {
        if (other == messages.PublicationProto.Publication.getDefaultInstance()) return this;
        if (other.company_ != 0) {
          setCompanyValue(other.getCompanyValue());
        }
        if (other.getStockValue() != 0D) {
          setStockValue(other.getStockValue());
        }
        if (other.getChange() != 0D) {
          setChange(other.getChange());
        }
        if (other.getVariation() != 0D) {
          setVariation(other.getVariation());
        }
        if (other.getDate() != 0L) {
          setDate(other.getDate());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        messages.PublicationProto.Publication parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (messages.PublicationProto.Publication) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private int company_ = 0;
      /**
       * <code>.stocks.Company company = 1;</code>
       * @return The enum numeric value on the wire for company.
       */
      @java.lang.Override public int getCompanyValue() {
        return company_;
      }
      /**
       * <code>.stocks.Company company = 1;</code>
       * @param value The enum numeric value on the wire for company to set.
       * @return This builder for chaining.
       */
      public Builder setCompanyValue(int value) {
        
        company_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>.stocks.Company company = 1;</code>
       * @return The company.
       */
      @java.lang.Override
      public messages.CompanyProto.Company getCompany() {
        @SuppressWarnings("deprecation")
        messages.CompanyProto.Company result = messages.CompanyProto.Company.valueOf(company_);
        return result == null ? messages.CompanyProto.Company.UNRECOGNIZED : result;
      }
      /**
       * <code>.stocks.Company company = 1;</code>
       * @param value The company to set.
       * @return This builder for chaining.
       */
      public Builder setCompany(messages.CompanyProto.Company value) {
        if (value == null) {
          throw new NullPointerException();
        }
        
        company_ = value.getNumber();
        onChanged();
        return this;
      }
      /**
       * <code>.stocks.Company company = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearCompany() {
        
        company_ = 0;
        onChanged();
        return this;
      }

      private double stockValue_ ;
      /**
       * <code>double stock_value = 2;</code>
       * @return The stockValue.
       */
      @java.lang.Override
      public double getStockValue() {
        return stockValue_;
      }
      /**
       * <code>double stock_value = 2;</code>
       * @param value The stockValue to set.
       * @return This builder for chaining.
       */
      public Builder setStockValue(double value) {
        
        stockValue_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>double stock_value = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearStockValue() {
        
        stockValue_ = 0D;
        onChanged();
        return this;
      }

      private double change_ ;
      /**
       * <code>double change = 3;</code>
       * @return The change.
       */
      @java.lang.Override
      public double getChange() {
        return change_;
      }
      /**
       * <code>double change = 3;</code>
       * @param value The change to set.
       * @return This builder for chaining.
       */
      public Builder setChange(double value) {
        
        change_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>double change = 3;</code>
       * @return This builder for chaining.
       */
      public Builder clearChange() {
        
        change_ = 0D;
        onChanged();
        return this;
      }

      private double variation_ ;
      /**
       * <code>double variation = 4;</code>
       * @return The variation.
       */
      @java.lang.Override
      public double getVariation() {
        return variation_;
      }
      /**
       * <code>double variation = 4;</code>
       * @param value The variation to set.
       * @return This builder for chaining.
       */
      public Builder setVariation(double value) {
        
        variation_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>double variation = 4;</code>
       * @return This builder for chaining.
       */
      public Builder clearVariation() {
        
        variation_ = 0D;
        onChanged();
        return this;
      }

      private long date_ ;
      /**
       * <code>int64 date = 5;</code>
       * @return The date.
       */
      @java.lang.Override
      public long getDate() {
        return date_;
      }
      /**
       * <code>int64 date = 5;</code>
       * @param value The date to set.
       * @return This builder for chaining.
       */
      public Builder setDate(long value) {
        
        date_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 date = 5;</code>
       * @return This builder for chaining.
       */
      public Builder clearDate() {
        
        date_ = 0L;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:stocks.Publication)
    }

    // @@protoc_insertion_point(class_scope:stocks.Publication)
    private static final messages.PublicationProto.Publication DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new messages.PublicationProto.Publication();
    }

    public static messages.PublicationProto.Publication getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Publication>
        PARSER = new com.google.protobuf.AbstractParser<Publication>() {
      @java.lang.Override
      public Publication parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new Publication(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Publication> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Publication> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public messages.PublicationProto.Publication getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_stocks_Publication_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_stocks_Publication_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\021publication.proto\022\006stocks\032\rcompany.pro" +
      "to\"u\n\013Publication\022 \n\007company\030\001 \001(\0162\017.sto" +
      "cks.Company\022\023\n\013stock_value\030\002 \001(\001\022\016\n\006chan" +
      "ge\030\003 \001(\001\022\021\n\tvariation\030\004 \001(\001\022\014\n\004date\030\005 \001(" +
      "\003B\034\n\010messagesB\020PublicationProtob\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          messages.CompanyProto.getDescriptor(),
        });
    internal_static_stocks_Publication_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_stocks_Publication_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_stocks_Publication_descriptor,
        new java.lang.String[] { "Company", "StockValue", "Change", "Variation", "Date", });
    messages.CompanyProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}