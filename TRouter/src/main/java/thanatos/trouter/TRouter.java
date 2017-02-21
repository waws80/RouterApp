package thanatos.trouter;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import thanatos.trouter.control.ClassService;
import thanatos.trouter.control.IService;
import thanatos.trouter.utils.ClassUtils;

/**
 * Created on 2017/2/21.
 * 作者：by thanatos
 * 作用：
 */

public class TRouter{

    private static final String TAG = "TRouter";

    private Context mContext;

    private TRouter(){

    }

    public IService create(Context context,@NotNull String packageName){
        mContext=context;
        if (packageName.isEmpty()) throw new IllegalArgumentException("the packagename is a effective parameter ?");
        try {
            return new ClassService(context, ClassUtils.getFileNameByPackageName(context,packageName));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static class Builder{

        public static TRouter build(){
            return new TRouter();
        }
    }



}
