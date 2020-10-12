package site.syzhou.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import site.syzhou.domain.User;

import java.util.List;
@CacheNamespace(blocking = true)
public interface IUserDao {
    @Select("select * from user")
    @Results(id="userMap",
            value= {
                    //此处id表示是否为主键，默认false
                    @Result(id=true,column="id",property="id"),
                    @Result(column="username",property="username"),
                    @Result(column="sex",property="sex"),
                    @Result(column="address",property="address"),
                    @Result(column="birthday",property="birthday"),
                    @Result(column = "id",property = "accounts",many=@Many(select = "site.syzhou.dao.IAccountDao.findById",fetchType = FetchType.LAZY))
            })
    public List<User> findAll();
    @Select("select * from user where id=#{id}")
    @ResultMap("userMap")
    public User findById(int id);
    @Insert("insert into user(username,birthday,sex,address) values(#{username},#{birthday},#{sex},#{address})")
    @SelectKey(keyColumn="id",keyProperty="id",resultType=Integer.class,before = false, statement = { "select last_insert_id()" })
    public int insertUser(User user);
    @Update("update user set username=#{username},birthday=#{birthday},sex=#{sex},address=#{address} where id=#{id}")
    public int updateUser(User user);
    @Delete("delete from user where id=#{id}")
    public void deleteUser(int id);
    @Select("select * from user where username like #{username} ")
    List<User> findByName(String name);
}
