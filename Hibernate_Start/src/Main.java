import PostgresSQL.StudentsEntity;
import com.sun.tools.javac.util.List;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.Map;

/**
 * Created by User on 08.04.16.
 */
public class Main {
    private static final SessionFactory ourSessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            ourSessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

        public static Session getSession() throws HibernateException {
            return ourSessionFactory.openSession();
        }

        public static void main(final String[] args) throws Exception {
            final Session session = getSession();
            try {
                System.out.println("querying all the managed entities...");
                final Map metadataMap = session.getSessionFactory().getAllClassMetadata();
                for (Object key : metadataMap.keySet()) {
                    final ClassMetadata classMetadata = (ClassMetadata) metadataMap.get(key);
                    final String entityName = classMetadata.getEntityName();
                    final Query q1 = session.createQuery("from StudentsEntity ");

                    System.out.printf("Getting all student");
                    for (Object o :q1.list()){
                        System.out.println(" "+o);
                    }

                }
            } finally {
                session.close();
            }
        }
    }

//    public static Session getSession() throws HibernateException {
//        return ourSessionFactory.openSession();
//    }
//
//    public static void main(final String[] args) throws Exception {
//        final Session session = getSession();
//        try {
//            System.out.println("querying all the managed entities...");
//            final Map metadataMap = session.getSessionFactory().getAllClassMetadata();
//            for (Object key : metadataMap.keySet()) {
//                final ClassMetadata classMetadata = (ClassMetadata) metadataMap.get(key);
//                final String entityName = classMetadata.getEntityName();
//                final Query query = session.createQuery("from " + entityName);
//                System.out.println("executing: " + query.getQueryString());
//                for (Object o : query.list()) {
//                    System.out.println("  " + o);
//                }
//            }
//        }
//        finally {
//            getStudentById();
//            session.close();
//        }
//    }
//
//    public static void getStudentById(){
//        Session session = HibernateUtil.getSessionFactory().openSession();
////        StudentsEntity student = (StudentsEntity) session.load(StudentsEntity.class, id);
////        session.close();
////        return  student;
//        Criteria cr = session.createCriteria(StudentsEntity.class);
//        for (Object o : cr.list()) {
//            System.out.println("  " + o);
//        }
//    }
//}
