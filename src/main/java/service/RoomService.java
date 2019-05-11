package service;

import dao.DaoFactory;
import dao.RoomDao;
import entity.Room;
import exception.DBException;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;

public class RoomService {

    public RoomService(){}

    public Room create(Room room) throws DBException {
        Transaction transaction = DBService.getTransaction();
        try {
            RoomDao roomDao = DaoFactory.getRoomDao();
            roomDao.create(room);
            transaction.commit();
            return room;
        } catch (HibernateException | NoResultException | NullPointerException e) {
            DBService.transactionRollback(transaction);
            throw new DBException(e);
        }
    }

    public Room get(long id) throws DBException {
        Transaction transaction = DBService.getTransaction();
        try {
            Room room = DaoFactory.getRoomDao().get(id);
            transaction.commit();
            return room;
        } catch (HibernateException | NoResultException | NullPointerException e) {
            DBService.transactionRollback(transaction);
            throw new DBException(e);
        }
    }
}
