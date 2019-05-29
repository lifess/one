package example.ss.com.commit2;

import java.util.List;

import example.ss.com.commit2.dao.DaoSession;
import example.ss.com.commit2.dao.UserBeanDao;

public class DBUtils {
    public static void insert (UserBean userBean){
        DaoSession daoSession = MyApplication.getDaoSession();
        if (queryItem(userBean) == null) {
            daoSession.insert(userBean);
        }
    }

    public static List<UserBean> queryAll() {
        DaoSession daoSession = MyApplication.getDaoSession();
        return daoSession.loadAll(UserBean.class);
    }
    public static UserBean queryItem(UserBean userBean){
        DaoSession daoSession = MyApplication.getDaoSession();
        UserBean unique = daoSession.queryBuilder(UserBean.class)
                .where(UserBeanDao.Properties.Name.eq(userBean.getName()))
                .build()
                .unique();
        return unique;
    }
}
