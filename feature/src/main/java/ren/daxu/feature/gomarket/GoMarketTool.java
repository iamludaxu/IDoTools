package ren.daxu.feature.gomarket;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

import ren.daxu.feature.app.AppTool;

public class GoMarketTool {

    private List<MarketData> mPriorityList = new ArrayList<>();


    public void sort() {
    }


    public static boolean hasAppMaket(Context context, String marketPkg) {
        final PackageManager packageManager = context.getPackageManager();//获取packagemanager
        List<PackageInfo> packageInfo = packageManager.getInstalledPackages(0);//获取所有已安装程序的包信息
        List<String> NameList = new ArrayList<String>();//用于存储所有已安装程序的包名
        //从packageInfo中取出包名，放入NameList中
        if (packageInfo != null) {
            for (int i = 0; i < packageInfo.size(); i++) {
                String pn = packageInfo.get(i).packageName;
                NameList.add(pn);
            }
        }
        return NameList.contains(marketPkg);//判断pName中是否有目标程序的包名，有TRUE，没有FALSE
    }


    /**
     * 打开应用商店评论
     *
     * @param context
     * @param appPkg
     */
    public void launchAppDetail(Context context, String appPkg) {
        try {
            if (TextUtils.isEmpty(appPkg))
                return;
            String marketPkg = null;
            List<PackageInfo> packageInfos = AppTool.queryApps(context, true);
            for (MarketData marketData : mPriorityList) {
                for (PackageInfo packageInfo : packageInfos) {
                    if (marketData.getMarketPkg().equals(packageInfo.packageName)) {
                        marketPkg = marketData.getMarketPkg();
                        break;
                    }
                }
            }

            Uri uri = Uri.parse("market://details?id=" + appPkg);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            if (!TextUtils.isEmpty(marketPkg))
                intent.setPackage(marketPkg);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
