## Distributed Computing Codes

1. RMI:

   1. Terminal 1 : javac \*.java
   2. Terminal 1 : rmic ConverterImplementation
   3. Terminal 1 : rmiregistry
   4. Terminal 2 : java Server
   5. Terminal 3 : java Client

2. MPI:

   1. javac -cp $MPJ_HOME/lib/mpj.jar Temp.java
   2. $MPJ_HOME/bin/mpjrun.sh -np 4 Temp

3. CORBA:

   1. idlj -fall Addition.idl
   2. Copy the module to both Client and Server
   3. Terminal 1 : orbd -ORBInitialPort 1050
   4. Terminal 2 : Go to Server and compile using javac StartServer.java -Xlint
   5. Terminal 2 : Run using java StartServer -ORBInitialPort 1050 -ORBInitialHost localhost
   6. Terminal 3 : Go to Client and compile using javac StartClient.java
   7. Terminal 3 : Run using java StartClient -ORBInitialPort 1050 -ORBInitialHost localhost
