package gen.greendao;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import java.util.Map;

import afkt.project.database.green.module.note.bean.Note;
import afkt.project.database.green.module.note.bean.NotePicture;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig noteDaoConfig;
    private final DaoConfig notePictureDaoConfig;

    private final NoteDao noteDao;
    private final NotePictureDao notePictureDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        noteDaoConfig = daoConfigMap.get(NoteDao.class).clone();
        noteDaoConfig.initIdentityScope(type);

        notePictureDaoConfig = daoConfigMap.get(NotePictureDao.class).clone();
        notePictureDaoConfig.initIdentityScope(type);

        noteDao = new NoteDao(noteDaoConfig, this);
        notePictureDao = new NotePictureDao(notePictureDaoConfig, this);

        registerDao(Note.class, noteDao);
        registerDao(NotePicture.class, notePictureDao);
    }
    
    public void clear() {
        noteDaoConfig.clearIdentityScope();
        notePictureDaoConfig.clearIdentityScope();
    }

    public NoteDao getNoteDao() {
        return noteDao;
    }

    public NotePictureDao getNotePictureDao() {
        return notePictureDao;
    }

}
