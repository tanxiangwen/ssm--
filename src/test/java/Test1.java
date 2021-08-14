import Pojo.Book;
import Service.BookManagerService;
import Service.impl.BookManagerServiceImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
@Controller
public class Test1 {
    @Autowired
BookManagerService bookManagerService;
    @Test
    public void test() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("BookManager.xml");
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        sqlSession.insert("Dao.mapper.BookManager.addBook", new Book(null,"kzshckac",new BigDecimal(100),"李四",99,10000,null));

    }
}
