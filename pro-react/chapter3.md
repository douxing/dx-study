# 使用组件来架构应用

## 验证Props

简单的前端验证, 一般使用React提供的propTypes即可.
默认值使用defaultProps来验证.

## 组件组合策略及最佳实践

组件包含两类数据:
- Props 不可改变
- State 可被设置

根据这两类数据的使用, 衍生出容器组件和展示组件.
一般情况下, 容器组件内有State, 并且给展示组件传递属性, 展示组件通过回调来改变State.

## 组件生命周期

要注意Props的改变和State的改变是不同的, Props改变会调用`componentWillReceiveProps`函数, State改变不会.
`componentWillReceiveProps`中调用`this.setState()`不会再次触发`render`.
一般在`componentDidMount`中使用`fetch`函数.
`componentWillUpdate`中不能再使用`this.setState()`, 可以在这里根据State进一步准备数据.

## 不可改变

dx注: 本书使用了`react-addons-update`来维持不变性, 可能已经不合适,
推荐使用[Immutable](https://facebook.github.io/immutable-js/).

## Kanban例子

主要的思想为:

- 在顶层有一个Container组件, 用来存取State, 和服务器交互等工作
- State以及回调函数, 都通过属性向下传递
- 在前端有一个预提交的过程, 在服务器真正响应请求后, 再根据结果更新/回滚数据



