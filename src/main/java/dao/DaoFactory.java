package dao;

import java.util.Arrays;
import java.util.List;

public abstract class DaoFactory {

    private static final List<Dao> daoList = Arrays.asList(
            new AddressDao(),
            new StudentDao()
    );

    private static <T extends Dao> T getDao(Class<T> cl){
        for(Dao dao : daoList){
            if (cl.isInstance(dao))
                return cl.cast(dao);
        }
        return null;
    }

    public static StudentDao getStudentDao(){
        return getDao(StudentDao.class);
    }

    public static AddressDao getAddressDao(){
        return getDao(AddressDao.class);
    }
}