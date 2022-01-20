package Package_Nine;

public class 背包1 {
    /**
     * 01 背包
     * N件物品，容量为 V,第i件物品重量为c[i],价值w[i]
     * 求将哪些物品装入背包价值最大
     */
    int N;
    int V;
    int[] c = new int[N];
    int[] w = new int[N];
    int getMaxValue(int[] c, int[] w, int v){
        int[] dp = new int[v+1];
        for (int i = 1; i <= c.length; i++) {
            for (int j = v; j >= c[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-c[i]]+w[i]);
            }
        }
        return dp[v];
    }

    //完全背包
    int getMaxValue2(int[] c, int[] w, int v){
        int[] dp = new int[v+1];
        for (int i = 1; i <= c.length; i++) {
            for (int j = c[i]; j <= v; j++) {
                dp[j] = Math.max(dp[j], dp[j-c[i]]+w[i]);
            }
        }
        return dp[v];
    }

    //多重背包  二维数组
//    for(int i=1;i<=n;i++) //物品数量
//    {
//        for(int j=1;j<=m;j++) //背包容量
//        {
//            for(int k=0;k<=s[i];k++) //物品数量可以选择0件，最多选择s[i]件
//            {
//                if(j<k*w[i])
//                    f[i][j]=f[i-1][j];
//                else
//                    f[i][j]=max(f[i-1][j],f[i-1][j-k*w[i]]+k*v[i]);
//            }
//        }
//    }

//    多重背包 一维数组



}
