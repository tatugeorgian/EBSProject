sending_times_file = open('sendingTimes.txt', 'r')

lines = sending_times_file.readlines()

sending_times_pubs = {}

totalSendingTime = 0
for line in lines:
    totalSendingTime = totalSendingTime + long(line.split(' ')[0])
    sending_times_pubs[line.split(' ')[1]] = line.split(' ')[0]

print("Total publications sent ", len(lines))


receiving_times = open('receivingTimes.txt', 'r')

lines = receiving_times.readlines()

total_latency = 0

totalReceivingTime = 0
for line in lines:
    totalReceivingTime = totalReceivingTime + long(line.split(' ')[0])
    latency = long(line.split(' ')[0]) - long(sending_times_pubs[line.split(' ')[1]])
    total_latency += latency

print("Total publications received ", len(lines))

print("Average latency ", total_latency / len(lines), " miliseconds")

