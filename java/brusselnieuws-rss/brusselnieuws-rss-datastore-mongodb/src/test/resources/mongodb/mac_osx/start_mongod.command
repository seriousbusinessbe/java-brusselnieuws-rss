#!/bin/sh
cd "`dirname "$0"`"
mongodb-osx-x86_64-2.6.4/bin/mongod --config ../../config/mongodb.config --setParameter enableLocalhostAuthBypass=0