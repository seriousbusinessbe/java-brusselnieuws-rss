# README:
#
# MongoDB set-up:

# PART 1.
# source: http://docs.mongodb.org/manual/tutorial/enable-authentication/

# 1.1 Enable authentication in the (java) mongo.properties files
=================================================================

set: 
security.authorization=enabled 

properties files:

/java/brusselnieuws-rss/brusselnieuws-rss-datastore-mongodb/src/test/resources/properties/test-brusselnieuws-rss-datastore-mongodb-mongo.properties
/java/brusselnieuws-rss/brusselnieuws-rss-datastore-mongodb/src/main/resources/properties/brusselnieuws-rss-datastore-mongodb-mongo.properties

# 1.2 Start the MongoDB (mongod) via localhost exception
=================================================================
add: --setParameter enableLocalhostAuthBypass=1 
as start-up parameter

Mac OS X, run: start_mongod_no_authentication.command

# 3. Create a user administrator
==============================================================
Mac OS X, run: start_mongo.command
Enter: 

use admin
db.createUser(
  {
    user: "test_admin",
    pwd: "test_admin_password",
    roles:
    [
      {
        role: "userAdminAnyDatabase",
        db: "admin"
      }
    ]
  }
)

# 4. Create a 'test_brusselnieuws' database
==============================================================
use test_brusselnieuws

PART 2.

source: http://docs.mongodb.org/manual/tutorial/add-user-to-database/

# 5. Connect to MongoDB with the appropriate privileges
==============================================================
Mac OS X, run: start_mongo_admin.command

# 6. Create a test user
==============================================================

use test_brusselnieuws
db.createUser(
    {
      user: "test_username",
      pwd: "test_password",
      roles: [
         { role: "readWrite", db: "test_brusselnieuws" }
      ]
    }
)










