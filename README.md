# CustomRecycler

 ###   **V1.0.1** 

 **一.自定义滑动布局ScrollLayout** 
默认初始值是不存在下拉刷新布局，只有设置setScrollMode（）
这个模式存在4种模式 全部，下拉，上拉，和没有，下拉只有全部和下拉才可以用，上拉只有上拉和全部可以使用

初始化
setScroll（onScollCall），设置刷新监听

结束刷新 
onScrollFinish（）；

 **二.自定义CustomRecycler** 
存在功能添加头部，尾部，删除头部和尾部
addHead（view）；addFoot（layoutId）；removeHead（view）；removerFoot（layout）；
存在上拉加载，和暂无更多
默认初始值是不存在上拉刷新布局，只有设置setScrollMode（）
初始化
addOnScroll（layout，adapter，scrollmode，onscollcall）

结束删除
onScrollFinish（）；
 **
三，自定义上拉刷新下拉加载布局 RecyclerLayout** 
功能是和一和二的合集
默认初始值是不存在下拉刷新和上拉布局，只有设置setScrollMode（）

初始化
with(ScrollMode.BOTH, new LinearLayoutManager(this), adapter, new OnScrollCall() {
            @Override
            public void callback(ScrollMode scrollMode) {

            }
        });

结束刷新
onScrollFinish（）；