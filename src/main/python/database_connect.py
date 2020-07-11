# 14.1 Multiple Apartments
# 7/2/20
import mysql.connector

cnx = mysql.connector.connect(user='elaine', password='elaine',
                              host='127.0.0.1',
                              database='ch14')

cursor = cnx.cursor()

query = ("SELECT * FROM aptTenants")

cursor.execute(query)

for (tenantID, aptID) in cursor: 
    print("tenant ID: {}, apartment ID: {}".format(tenantID, aptID))
cursor.close()
cnx.close()

