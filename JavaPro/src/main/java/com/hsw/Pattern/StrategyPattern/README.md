#策略模式
> 本文来源于<<Head First设计模式>>.写出来是为了更好的吸收文中的精华,借用书中的例子和代码再阐述.

## 我们引出一个问题
  我们OO程序员根据最初的需求设计了一个Duck类,Duck可以游泳swin,Duck可以叫queak,Duck有外形display.但是不同鸭子的外形可能不一样,因此dispaly定义为抽象方法.那么我们所有的鸭子都来继承Duck这个超类.
这样,我们的鸭子都有游泳和叫换的功能,我们也借助于继承,实现了代码的复用.
  这样我们也确实做到了一个OO程序员的基本要求了.但是当我们有这样一个需求的时候.
  领导让我们给鸭子加一个飞fly的功能,那么我们很容易就想到了在超类Duck中再加一个fly的方法.但是**问题来了**,不同类型的鸭子飞行的方式可能不一样,而且也不是所有的鸭子都能飞
  ,那么就算把fly这个方法改成抽象方法也无法合理的解决这个问题.我们不能让不能飞的鸭子也继承了这个fly的方法.
  虽然我们可以用覆盖的方式解决这个问题,但这绝不是最好的方法

