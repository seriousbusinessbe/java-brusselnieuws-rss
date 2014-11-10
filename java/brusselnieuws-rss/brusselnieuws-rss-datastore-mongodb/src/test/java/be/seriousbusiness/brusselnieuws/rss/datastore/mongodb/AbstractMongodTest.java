package be.seriousbusiness.brusselnieuws.rss.datastore.mongodb;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.logging.Level;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.MongoClient;

import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.config.io.ProcessOutput;
import de.flapdoodle.embed.process.io.Processors;
import de.flapdoodle.embed.process.runtime.Network;

public class AbstractMongodTest {
	private static final Logger LOGGER=LoggerFactory.getLogger(AbstractMongodTest.class);
	
	/**
     * please store mongodStarter or RuntimeConfig in a static final field
     * if you want to use artifact store caching (or else disable caching)
     */
    private static final MongodStarter MONGOD_STARTER = MongodStarter.getDefaultInstance();
    
    private static MongodExecutable MONGOD_EXECUTABLE;
    private static MongodProcess MONGOD_PROCESS;
    private static MongoClient MONGO_CLIENT;
    
    @BeforeClass
    public static void beforeClass() throws UnknownHostException{
    	try{
	    	MONGOD_EXECUTABLE = MONGOD_STARTER.prepare(new MongodConfigBuilder()
	        .version(Version.Main.PRODUCTION)
	        .net(new Net(12345, Network.localhostIsIPv6()))
	        .build());
    	}catch(final IOException e){
    		LOGGER.error("A mongod executable could not be created",e);
    	}
    	try {
			MONGOD_PROCESS = MONGOD_EXECUTABLE.start();
		} catch (final IOException e) {
			LOGGER.error("Mongod could not be started",e);
		}
    	
    	MONGO_CLIENT = new MongoClient("localhost", 12345);
    }
    
    @AfterClass
    public static void afterClass() throws Exception {
        MONGOD_PROCESS.stop();
        MONGOD_EXECUTABLE.stop();
    }
    
    public static MongoClient getMongo(){
    	return MONGO_CLIENT;
    }

}
