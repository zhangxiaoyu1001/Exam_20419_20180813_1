运行过程：

启动服务器

-->页面跳转至index.jsp页面，显示登陆login，添加film，显示file表中所有信息等功能
   
   修改和删除功能在显示列表中操作。

-->1.index界面,使用filter拒绝未登录用户操作功能
    
    未登录的用户不能操作除login以外的功能，否则会跳转至fail.jsp,给出错误提示，

-->2.登录
    
    登录成功，跳转界面至显示film列表
    
    登录失败，跳转至fail.jsp界面

-->3.显示列表信息,

    在后台显示的数据完全正确，可以查找出来，就是前台jsp显示有问题，暂时没有改出来

-->4.添加film

    结果图是后台的测试数据，film表中原有1000条数据，经过添加language_id为3的film后，（1是运行ps.executeUpdate()的返回结果），查找表中数据共有1001条。

   