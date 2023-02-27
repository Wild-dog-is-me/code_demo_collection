# 数据模型转换MybatisPlus DO BO DTO VO

## 什么是DO PO DTO VO BO

### 1、PO/DO

PO/DO: Persistent Object / Data Object，持久对象 / 数据对象。

- 跟数据库表是一一对应的，一个PO/DO 数据是表的一条记录。
- PO / DO 只是数据的对象，不包含任何的操作。举个例子，学生表是StudentDO，对学生表的增删改查等操作就是StudentDAO。
- DO(Data Object) ，持久化对象，它跟持久层(Dao)的数据结构形成一一对应的映射关系。如果持久层是关系型数据库，那么数据库表中的每个字段就对应PO的一个属性，常是entity实体类。

### 2、VO

VO (View Object)，用于表示一个与前端进行交互的视图对象，它的作用是把某个指定页面(或组件)的所有数据封装起来。实际上，这里的 VO 只包含前端需要展示的数据，对于前端不需要的数据，比如数据创建和修改的时间等字段，出于减少传输数据量大小和保护数据库结构不外泄的目的，不应该在 VO 中体现出来。

### 3、DTO

DTO(Data Transfer Object)，用于表示一个数据传输对象，DTO 通常用于展示层(Controller)和服务层(Service)之间的数据传输对象。DTO 与 VO 概念相似，并且通常情况下字段也基本一致。但 DTO 与 VO 又有一些不同，这个不同主要是设计理念上的，比如 API 服务需要使用的 DTO 就可能与 VO 存在差异。

### 4、Bo

POJO在业务层的体现，对于业务操作来说，更多的是从业务上来包装对象，如一个User的BO，可能包括name, age, sex, privilege, group等，这些属性在数据库中可能会在多张表中，因为每一张表对应一个PO，而我们的BO需要这些PO组合起来(或说重新拼装)才能成为业务上的一个完整对象。



## DO PO DTO VO 数据流转关系

1、DO -> 控制器返回

2、DO -> PO -> 控制器返回

3、DO -> PO -> VO -> 控制器返回

4、DO -> DTO -> 控制器返回

5、DO -> PO -> VO -> 控制器返回

6、DO -> PO -> DTO -> 控制器返回
