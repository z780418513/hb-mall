package com.hb.mall.common.utils;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import cn.hutool.core.lang.tree.parser.NodeParser;
import cn.hutool.core.util.ReflectUtil;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @author: zhaochengshui
 * @description 树形转换工具类
 * @date: 2023/10/15 08:58
 */
public class TreeHelper {

    /**
     * list转tree
     *
     * @param originList 原始数组
     * @param rootId     根ID
     * @param <T>        节点id类型
     * @param <E>        集合对象类型
     * @return tree集合
     */
    public static <T, E> List<Tree<T>> toTreeList(List<E> originList, T rootId) {
        if (CollUtil.isEmpty(originList)) {
            return ListUtil.empty();
        }

        return toTreeList(originList, rootId, getDefaultTreeNodeConfig(), getDefaultIgnoreList());
    }

    /**
     * list转tree
     *
     * @param originList 原始数组
     * @param rootId     根ID
     * @param <T>        节点id类型
     * @param <E>        集合对象类型
     * @param config     TreeNodeConfig
     * @param ignoreList 数节点需要忽略的字段
     * @return tree集合
     */
    public static <T, E> List<Tree<T>> toTreeList(List<E> originList, T rootId, TreeNodeConfig config, List<String> ignoreList) {
        if (CollUtil.isEmpty(originList)) {
            return ListUtil.empty();
        }

        return TreeUtil.build(originList, rootId, config,
                (object, treeNode) -> {
                    Field[] fields = ReflectUtil.getFieldsDirectly(object.getClass(), true);
                    for (Field field : fields) {
                        String fieldName = field.getName();
                        if (!ignoreList.contains(fieldName)) {
                            Object fieldValue = ReflectUtil.getFieldValue(object, field);
                            treeNode.putExtra(fieldName, fieldValue);
                        }
                    }
                });
    }

    /**
     * list转tree
     *
     * @param originList 原始数组
     * @param rootId     根ID
     * @param <T>        节点id类型
     * @param <E>        集合对象类型
     * @param config     TreeNodeConfig
     * @param nodeParser 树节点解析器
     * @return tree集合
     */
    public static <T, E> List<Tree<T>> toTreeList(List<E> originList, T rootId, TreeNodeConfig config, NodeParser<E, T> nodeParser) {
        if (CollUtil.isEmpty(originList)) {
            return ListUtil.empty();
        }
        return TreeUtil.build(originList, rootId, config, nodeParser);
    }

    /**
     * 获取默认树配置属性相关
     *
     * @return 默认树配置属性相关
     */
    private static TreeNodeConfig getDefaultTreeNodeConfig() {
        TreeNodeConfig config = new TreeNodeConfig();
        config.setIdKey("id");                         //默认id，可以不设置
        config.setParentIdKey("parentId");                       //父id
        config.setChildrenKey("childrenList");              //孩子节点
//        config.setNameKey("dataCategoryName");              //分类名称
//        config.setDeep(3);                                  //最大递归深度
//        config.setWeightKey("sort");                        //排序字段
        return config;
    }

    /**
     * 获取默认忽略字段
     *
     * @return 默认忽略字段
     */
    private static List<String> getDefaultIgnoreList() {
        return ListUtil.toList("serialVersionUID");
    }

    private TreeHelper() {
    }

}
