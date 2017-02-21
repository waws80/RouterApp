package thanatos.routerapp;

import android.app.Application;

import thanatos.trouter.TRouter;
import thanatos.trouter.control.IService;

/**
 * Created on 2017/2/21.
 * 作者：by thanatos
 * 作用：
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        TRouter build = TRouter.Builder.build();
        IService service = build.create(this,"thanatos.routerapp");
        //service.openPath("android://activity/thanatos.routerapp.Main2Activity.class");
    }
}
