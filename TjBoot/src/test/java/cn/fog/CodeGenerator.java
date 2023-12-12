package cn.fog;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class CodeGenerator {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/tj?serverTimezone=UTC";
        String username = "root";
        String password = "1234";
        String moduleName = "tj";
        String table = "x_user,x_role,x_menu,x_user_role,x_role_menu,x_employee,x_za,x_month,x_gather";
        String mapperLocation = "D:\\Strive\\MyBoot\\TjBoot\\src\\main\\resources\\mapper\\"+moduleName;
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("Fog") // 设置作者
//                            .enableSwagger() // 开启 swagger 模式
//                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D:\\Strive\\MyBoot\\TjBoot\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("cn.fog") // 设置父包名
                            .moduleName("tj") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, mapperLocation)); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude(table) // 设置需要生成的表名
                            .addTablePrefix("x_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
