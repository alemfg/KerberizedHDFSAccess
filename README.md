# KerberizedHDFSAccess
This repository contains sample code to access kerberized hdfs through JAAS conf

# Client Config Files Setup 
Please download the client config files core-site.xml and hdfs-site.xml to /etc/hadoop/config/client/

# Please see the excerpts from outputa of run
```bash
cd /Users/vsingh/github/KerberizedHDFSAccess/KerberizedHDFSClient ; JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_66.jdk/Contents/Home M2_HOME=/Users/vsingh/Software/apache-maven-3.3.3 /Users/vsingh/Software/apache-maven-3.3.3/bin/mvn "-Dexec.args=-classpath %classpath com.amintor.hdfs.client.kerberizedhdfsclient.KerberizedHDFSClient /user/" -Dexec.executable=/Library/Java/JavaVirtualMachines/jdk1.8.0_66.jdk/Contents/Home/bin/java org.codehaus.mojo:exec-maven-plugin:1.2.1:exec
[INFO] Scanning for projects...
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building KerberizedHDFSClient 1.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- exec-maven-plugin:1.2.1:exec (default-cli) @ KerberizedHDFSClient ---
Authentication Type:kerberos
log4j:WARN No appenders could be found for logger (org.apache.hadoop.metrics2.lib.MutableMetricsFactory).
log4j:WARN Please initialize the log4j system properly.
log4j:WARN See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.
Replication:0	Owner:hdfs	Group:supergroup	Path:hdfs://vjsf-1.gce.cloudera.com:8020/user/hdfs	
Replication:0	Owner:mapred	Group:hadoop	Path:hdfs://vjsf-1.gce.cloudera.com:8020/user/history	
Replication:0	Owner:hive	Group:hive	Path:hdfs://vjsf-1.gce.cloudera.com:8020/user/hive	
Replication:0	Owner:hue	Group:hue	Path:hdfs://vjsf-1.gce.cloudera.com:8020/user/hue	
Replication:0	Owner:impala	Group:impala	Path:hdfs://vjsf-1.gce.cloudera.com:8020/user/impala	
Replication:0	Owner:oozie	Group:oozie	Path:hdfs://vjsf-1.gce.cloudera.com:8020/user/oozie	
Replication:0	Owner:spark	Group:spark	Path:hdfs://vjsf-1.gce.cloudera.com:8020/user/spark	
Replication:0	Owner:vijay	Group:vijay	Path:hdfs://vjsf-1.gce.cloudera.com:8020/user/vijay	
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 4.216 s
[INFO] Finished at: 2016-03-01T00:56:47-06:00
[INFO] Final Memory: 11M/309M
[INFO] ------------------------------------------------------------------------
```
