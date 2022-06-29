import pandas as pd
import random

locs1 = ["Cochin", "Trivandrum", "Kozhikode", "Mumbai", "NewDelhi"]
locs2 = ["Dammam", "Riyadh", "Qatar", "Kuwait", "Dubai"]
names = ["Air India", "Indigo", "Air Asia", "Fly Dubai", "SpiceJet"]
name_map = {"Air India": "AI", "Indigo": "IN", "Air Asia": "AS", "Fly Dubai": "FD", "SpiceJet": "SJ"}

df = pd.DataFrame(columns=['Name', 'Flight no', 'Departure Airport', 'Destination Airport',
        'Departure Time','Arival Time','Businessclass seats','Economyclass seats',
        'Economyclass ticket fare','Businessclass ticket fare'])
print(df)
for x in range(200):
    name = names[random.randint(0, len(names) - 1)]
    flightNo = name_map[name]+str(random.randint(100,900))
    departure_airport = locs1[random.randint(0, len(locs1) - 1)]
    arival_airport = locs2[random.randint(0, len(locs2) - 1)]
    departure_time = random.randint(0,19)
    arrival_time = random.randint(departure_time,23)

    if arrival_time-departure_time <= 4:
        arrival_time = (arrival_time + random.randint(4,7)) % 24
    businessclass_seats = random.randint(10,30)
    economyclass_seats = random.randint(150,200)
    economyclass_ticket_fare = random.randint(10000,100000)
    businessclass_ticket_fare = random.randint(economyclass_ticket_fare+20000,150000)
    new = [name, flightNo, departure_airport, arival_airport,departure_time, arrival_time,
          businessclass_seats,economyclass_seats,economyclass_ticket_fare,businessclass_ticket_fare]
    df.loc[x] = new

print(df.iloc[:,:6])
df.to_csv("flight_details.csv")

