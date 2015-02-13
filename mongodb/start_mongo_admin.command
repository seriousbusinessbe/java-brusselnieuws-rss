#!/bin/sh
cd "`dirname "$0"`"
mongodb-osx-x86_64-2.6.7/bin/mongo --port 27018 -u test_admin -p test_admin_password --authenticationDatabase admin