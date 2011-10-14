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
name             varchar(45) PK
isdir            tinyint(1)
modificationTime bigint(20)
atime            bigint(20)
permissions      varchar(45)
nsQuota          bigint(20)
dsQuota          bigint(20)
isUnderConstruction tinyint(1)
clientName       varchar(45)
clientMachine    varchar(45)
clientNode       varchar(45)
isClosedFile     tinyint(1)
header           bigint(20) // Stores replication factor, preferredBlocks
Parent           varchar(45)

 *
 * @author Lalith Suresh<suresh.lalith@gmail.com>
 */
@PersistenceCapable(table="InodeTable")
public interface InodeTable {

    // Inode
    @PrimaryKey
    @Column(name = "name")
    String getName ();     // id of the file system
    void setName (String name);

    // marker for InodeDirectoryWithQuota
    @Column(name = "isDir")
    boolean getIsDir ();
    void setIsDir (boolean isDir);

    // Inode
    @Column(name = "modificationTime")
    long getModificationTime ();
    void setModificationTime (long modificationTime);

    // Inode
    @Column(name = "aTime")
    long getATime ();
    void setATime (long modificationTime);

    // Inode
    @Column(name = "permission")
    long getPermission (); 
    void setPermission (long permission);

    // InodeDirectoryWithQuota
    @Column(name = "nsquota")
    long getNSQuota ();           // creation time of the file system state
    void setNSQuota (long nsQuota);

    // InodeDirectoryWithQuota
    @Column(name = "dsquota")
    long getDSQuota ();
    void setDSQuota (long dsQuota);

    //  marker for InodeFileUnderConstruction
    @Column(name = "isUnderConstruction")
    boolean getIsUnderConstruction ();
    void setIsUnderConstruction (boolean isUnderConstruction);

    // InodeFileUnderConstruction
    @Column(name = "clientName")
    String getClientName ();
    void setClientName (String isUnderConstruction);

    // InodeFileUnderConstruction
    @Column(name = "clientMachine")
    String getClientMachine ();
    void setClientMachine (String clientMachine);

    // InodeFileUnderConstruction -- TODO
    @Column(name = "clientNode")
    String getClientNode ();
    void setClientNode (String clientNode);

    //  marker for InodeFile
    @Column(name = "isClosedFile")
    boolean getIsClosedFile ();
    void setIsClosedFile (boolean isClosedFile);

    // InodeFile
    @Column(name = "header")
    long getHeader ();
    void setHeader (long header);

    // Inode
    // point to another entry in the InodeTable
    @Column(name = "parent")
    String getParent ();
    void setParent (String parent);

}
