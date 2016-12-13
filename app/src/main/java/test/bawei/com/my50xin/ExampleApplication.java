package test.bawei.com.my50xin;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * autour: 李海宽
 * date: $date$ $time$
 * update: $date$
 */
public class ExampleApplication extends Application {
    //内存泄漏
    public static RefWatcher getRefWatcher(Context context) {
        ExampleApplication application = (ExampleApplication) context
                .getApplicationContext();
        return application.refWatcher;
    }

    private RefWatcher refWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
//        LeakCanary这是会随着你app的运行，自动安装监测，给你通知。
//        方便你查看那个类出现了内存泄漏，甚至告诉你泄漏了多少M
        refWatcher = LeakCanary.install(this);
    }

}
