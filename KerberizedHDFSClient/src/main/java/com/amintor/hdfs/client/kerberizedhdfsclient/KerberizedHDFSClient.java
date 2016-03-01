/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amintor.hdfs.client.kerberizedhdfsclient;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.DFSClient;
import org.apache.hadoop.hdfs.protocol.HdfsFileStatus;
import org.apache.hadoop.hdfs.protocol.datatransfer.sasl.SaslDataTransferClient;
import org.apache.hadoop.security.UserGroupInformation;

/**
 *
 * @author vsingh
 */
public class KerberizedHDFSClient {

  private static final String HDFS_SITE_LOCATION = "/etc/hadoop/config/client/hdfs-site.xml";
  private static final String CORE_SITE_LOCATION = "/etc/hadoop/config/client/core-site.xml";
  private static final String NAMENODE_URI = "hdfs://vjsf-1.gce.cloudera.com:8020";

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    
    try {
      Configuration conf = new Configuration();
      conf.addResource(new FileInputStream(HDFS_SITE_LOCATION));
      conf.addResource(new FileInputStream(CORE_SITE_LOCATION));
      String authType = conf.get("hadoop.security.authentication");
      System.out.println("Authentication Type:" + authType);
      if (authType.trim().equalsIgnoreCase("kerberos")) {
        // Login through UGI keytab
        UserGroupInformation.setConfiguration(conf);
        UserGroupInformation.loginUserFromKeytab("vijay", "/Users/vsingh/Software/vijay.keytab");
        FileSystem hdFS = FileSystem.get(conf);
        FileStatus[] listStatus = hdFS.listStatus(new Path(args[0]));
        for(FileStatus statusFile : listStatus) {
          System.out.print("Replication:" +statusFile.getReplication()+"\t");
          System.out.print("Owner:"+statusFile.getOwner()+"\t");
          System.out.print("Group:"+statusFile.getGroup()+"\t");
          System.out.println("Path:"+statusFile.getPath()+"\t");
        }
         
      }
    } catch (IOException ex) {
      Logger.getLogger(KerberizedHDFSClient.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

}
