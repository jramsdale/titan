package com.thinkaurelius.titan.blueprints;

import com.thinkaurelius.titan.core.TitanFactory;
import com.thinkaurelius.titan.diskstorage.hbase.ExternalHBaseStorageSetup;
import com.thinkaurelius.titan.diskstorage.hbase.HBaseStorageManager;
import com.thinkaurelius.titan.graphdb.configuration.GraphDatabaseConfiguration;
import com.tinkerpop.blueprints.Graph;

/**
 * (c) Matthias Broecheler (me@matthiasb.com)
 */

public class ExternalHBaseBlueprintsTest extends LocalBlueprintsTest {


    @Override
    public void startUp() {
        //Start HBase
    }

    @Override
    public void shutDown() {
        //Stop HBase
    }

    @Override
    public Graph generateGraph() {
        Graph graph = TitanFactory.open(ExternalHBaseStorageSetup.getHBaseGraphConfiguration());
        return graph;
    }

    @Override
    public void cleanUp() {
        HBaseStorageManager s = new HBaseStorageManager(
                ExternalHBaseStorageSetup.getHBaseGraphConfiguration().subset(GraphDatabaseConfiguration.STORAGE_NAMESPACE));
        s.clearStorage();
    }


}