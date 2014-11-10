package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb;

import java.io.IOException;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.MongoClient;

import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;

public class TestMongo {
	private static final Logger LOGGER=LoggerFactory.getLogger(TestMongo.class);
	
	/**
     * please store mongodStarter or RuntimeConfig in a static final field
     * if you want to use artifact store caching (or else disable caching)
     */
    private static final MongodStarter MONGOD_STARTER = MongodStarter.getDefaultInstance();

    private static MongodExecutable MONGOD_EXECUTABLE=null;
    private static MongodProcess MONGOD_PROCESS=null;
    private static MongoClient MONGO_CLIENT=null;
    
    public static final MongoClient getInstance() throws UnknownHostException{
    	if(MONGO_CLIENT==null){
	    	
	    	
	    	try {
				MONGO_CLIENT = new MongoClient("localhost", 12345);
			} catch (final UnknownHostException e) {
				LOGGER.error("Mongo client could not be created",e);
				throw e;
			}
    	}
    	return MONGO_CLIENT;
    }
    
    public static final void start(){
    	if(MONGOD_EXECUTABLE==null){
    		try{
		    	MONGOD_EXECUTABLE = MONGOD_STARTER.prepare(new MongodConfigBuilder()
		        .version(Version.Main.PRODUCTION)
		        .net(new Net(12345, Network.localhostIsIPv6()))
		        .build());
	    	}catch(final IOException e){
	    		LOGGER.error("A mongod executable could not be created",e);
	    	}
    	}
    	if(MONGOD_PROCESS==null){
    		try {
				MONGOD_PROCESS = MONGOD_EXECUTABLE.start();
			} catch (final IOException e) {
				LOGGER.error("Mongod could not be started",e);
			}
    	}
    }
    
    public static final void stop(){
    	MONGOD_PROCESS.stop();
        MONGOD_EXECUTABLE.stop();
        MONGOD_PROCESS=null;
        MONGOD_EXECUTABLE=null;
    }


}
