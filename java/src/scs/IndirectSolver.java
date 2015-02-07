package scs;

public class IndirectSolver implements IConeSolver {
    static {
        System.loadLibrary("jscsindir"); // Load native library at runtime
    }

    private static native void csolve(AMatrix A, double[] b, double[] c, Cone k, Settings p, Solution s, Info info);

    public void solve(Data d, Cone k, Settings p, Solution sol, Info info) {
        csolve(d.getA(), d.getB(), d.getC(), k, p, sol, info);
    }
}