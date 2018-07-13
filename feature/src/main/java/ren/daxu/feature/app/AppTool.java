package ren.daxu.feature.app;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

import java.util.ArrayList;
import java.util.List;

public class AppTool {

    public static List<PackageInfo> queryApps(Context context, boolean isFilterSystem) {
        List<PackageInfo> packageInfos = context.getPackageManager().getInstalledPackages(0);
        if (isFilterSystem) {
            List<PackageInfo> list = new ArrayList<>();
            for (PackageInfo packageInfo : packageInfos) {
                if ((ApplicationInfo.FLAG_SYSTEM & packageInfo.applicationInfo.flags) == 0) {
                    list.add(packageInfo);
                }
                return list;
            }
        } else {
            return packageInfos;
        }
        return null;
    }


}
