import mpi.MPI;

public class Assignment2 {
    public static void main(String args[]) {
        MPI.Init(args);
        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();
        int root = 0;
        double[] sendbuf = null;

        sendbuf = new double[size];

        if(rank == root) {
            sendbuf[0] = 10;
            sendbuf[1] = 20;
            sendbuf[2] = 30;
            sendbuf[3] = 40;

            System.out.println("Original array is:- ");
            for(int i = 0; i < size; i++) {
                System.out.println("sendbuf[" + i + "] = " + sendbuf[i]);
            }
            System.out.println();
        }

        double recvbuf[] = new double[1];

        MPI.COMM_WORLD.Scatter(sendbuf, 0, 1, MPI.DOUBLE, recvbuf, 0, 1, MPI.DOUBLE, root);

        recvbuf[0] = 1/recvbuf[0];

        MPI.COMM_WORLD.Gather(recvbuf, 0, 1, MPI.DOUBLE, sendbuf, 0, 1, MPI.DOUBLE, root);

        if(rank == root) {
            System.out.println("Reciprocals are:- ");
            for(int i = 0; i < size; i++) {
                System.out.println("sendbuf[" + i + "] = " + sendbuf[i]);
            }
            System.out.println();
        }

        MPI.Finalize();
    }
}