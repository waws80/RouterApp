package thanatos.trouter.control;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

/**
 * Created on 2017/2/21.
 * 作者：by thanatos
 * 作用：
 */

public class ClassService implements IService {

    private static final String TAG = "ClassService";

    private Context mContext;

    private List<String> className;
    public ClassService(Context context, List<String> className) {
        this.mContext=context;
        this.className=className;

    }

    /**
     *
     * @param path eg:  android://activity/packageName.A.class
     *                  android:// is host
     *                  activity is type
     */

    @Override
    public  void openPath(String path) {
        if (path.isEmpty()) throw new NullPointerException("the path is can not null");
        if (!path.contains("android://")) throw new IllegalArgumentException("the path is contains android://type/ ?");
        String[] split = path.split("://");
        if (split[1].contains("activity/")||split[1].contains("service/")||split[1].contains("receiver/")){
            String uri = split[1];
            String[] strings = uri.split("/");
            String name = strings[1].replace(".class","");
            try {
                Class clazz=Class.forName(name);
                Intent intent=new Intent(mContext,clazz);
                jumpPath(intent,strings[0]);
            } catch (ClassNotFoundException e) {
                Toast.makeText(mContext, "跳转的界面不存在", Toast.LENGTH_SHORT).show();
            }

        }else {
            throw new IllegalArgumentException("the path is contains android://type/ ?");
        }

    }

    @Override
    public void openForName(String name) {
        for (String clazzName :className) {
            Log.w(TAG, "openForName: "+clazzName );
        }
    }

    private void jumpPath(Intent intent, String type) {

        switch (type){
            case "activity":
                mContext.startActivity(intent);
                break;
            case "service":
                mContext.startService(intent);
                break;
            case "receiver":
                Toast.makeText(mContext, "期待中。。。", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

    }
}
