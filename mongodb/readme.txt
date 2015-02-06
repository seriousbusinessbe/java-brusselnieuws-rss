# README:
#
# MongoDB set-up:

=================================================================
=================================================================
# PART 1.
=================================================================
=================================================================


# 1.1 Enable authentication in the (java) mongo.properties files
# source: http://docs.mongodb.org/manual/tutorial/enable-authentication/
=================================================================

set: 
security.authorization=enabled 

properties files:

/java/brusselnieuws-rss/brusselnieuws-rss-datastore-mongodb/src/test/resources/properties/test-brusselnieuws-rss-datastore-mongodb-mongo.properties
/java/brusselnieuws-rss/brusselnieuws-rss-datastore-mongodb/src/main/resources/properties/brusselnieuws-rss-datastore-mongodb-mongo.properties

# 1.2 Start the MongoDB (mongod) via localhost exception
=================================================================
add: 
--setParameter enableLocalhostAuthBypass=1 
as start-up parameter

Mac OS X, terminal command (or run: start_mongod_no_authentication.command):
mongodb-osx-x86_64-2.6.7/bin/mongod --config config/mongodb.config --setParameter enableLocalhostAuthBypass=1

# 1.3 Create an administrator user
=================================================================

# Mac OS X, terminal command (or run: start_mongo.command):
mongodb-osx-x86_64-2.6.7/bin/mongo --port 27018

# Mac OS X, terminal enter: 
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

# Result:
Successfully added user: {
  "user" : "test_admin",
  "roles" : [
    {
      "role" : "userAdminAnyDatabase",
      "db" : "admin"
    }
  ]
}

# 1.4 Create a 'test_brusselnieuws' database
=================================================================

# Mac OS X, terminal enter: 
use test_brusselnieuws

=================================================================
=================================================================
# PART 2.
=================================================================
=================================================================


# 5. Connect to MongoDB with the appropriate privileges
# source: http://docs.mongodb.org/manual/tutorial/add-user-to-database/
=================================================================

# Mac OS X, terminal command (or run: start_mongo_admin.command):
mongodb-osx-x86_64-2.6.7/bin/mongo --port 27018 -u test_admin -p test_admin_password --authenticationDatabase admin

# 6. Create a new 'test' user
=================================================================

# Mac OS X, terminal enter: 
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

# Result:
Successfully added user: {
  "user" : "test_username",
  "roles" : [
    {
      "role" : "readWrite",
      "db" : "test_brusselnieuws"
    }
  ]
}


=================================================================
=================================================================
# Warnings and errors:
=================================================================
=================================================================

Warning during startup of mongod: 
** WARNING: soft rlimits too low. Number of files is 256, should be at least 1000

Information:
http://docs.mongodb.org/manual/reference/ulimit/









