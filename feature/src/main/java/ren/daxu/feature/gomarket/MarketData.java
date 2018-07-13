package ren.daxu.feature.gomarket;

public enum MarketData {

    XIAOMI("xiaomi", ""),
    QIHOO360("qihoo360", "com.qihoo.appstore"),
    TAOBAO("taobao", "com.taobao.appcenter"),
    TENCENT("tencent", "com.tencent.android.qqdownloader"),
    HIAPK("hiapk", "com.hiapk.marketpho"),
    GOAPK("goapk", "cn.goapk.market"),
    SAMSUNG("samsung", "com.sec.android.app.samsungapps");

    private String marketName;
    private String marketPkg;

    MarketData(String marketName, String marketPkg) {
        this.marketName = marketName;
        this.marketPkg = marketPkg;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getMarketPkg() {
        return marketPkg;
    }

    public void setMarketPkg(String marketPkg) {
        this.marketPkg = marketPkg;
    }
}
