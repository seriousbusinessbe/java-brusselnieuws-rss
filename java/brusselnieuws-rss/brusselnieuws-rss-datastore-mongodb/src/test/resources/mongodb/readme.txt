# README:
#
# Before the test can be ran a databse and user needs to be created!
# To do this, follow underneath steps:

PART 1.

source: http://docs.mongodb.org/manual/tutorial/enable-authentication/

# 1. Set authentication enabled in the mongodb properties file
==============================================================
set: security.authorization=enabled 
in test-mongo.properties

# 2. Start the MongoDB (mongod) via localhost exception
==============================================================
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










