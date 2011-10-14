/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.sics.clusterj;

import com.mysql.clusterj.annotation.Column;
import com.mysql.clusterj.annotation.PersistenceCapable;
import com.mysql.clusterj.annotation.PrimaryKey;

/**
 * 
 *  
CREATE TABLE `my_data` (
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`data` varbinary(255) DEFAULT NULL,
`last_updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`) ) ENGINE=ndbcluster DEFAULT CHARSET=latin1;

 *
 * @author Lalith Suresh<suresh.lalith@gmail.com>
 */
@PersistenceCapable(table="StorageInfoSql")
public interface StorageInfoSql {

    @PrimaryKey
    @Column(name = "namespaceId")
    int getNamespaceId ();     // id of the file system
    void setNamespaceId (int namespaceId);

    @Column(name = "layoutVersion")
    int getLayoutVersion ();
    void setLayoutVersion (int layoutVersion);

    @Column(name = "clusterId")
    String getClusterId ();      // id of the cluster
    void setClusterId (String clusterID);

    @Column(name = "cTime")
    long getCTime ();           // creation time of the file system state
    void setCTime (long cTime);
}
