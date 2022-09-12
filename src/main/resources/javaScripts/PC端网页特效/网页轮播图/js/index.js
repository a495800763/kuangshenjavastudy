// 轮播图功能需求总结
//1 鼠标经过轮播图模块，左右按钮显式，离开模块左右按钮隐藏
//2 每点击一次按钮，图片往相应方向播放一张，
//3 图片播放的同时，下面的小圆圈跟随图片一起变化，显示当前第几张图
//4 点击相应的小圆圈，可以直接跳到对应的图片
//5 鼠标不经过轮播图模块时，轮播图自动对图片进行顺序播放
//6 鼠标经过轮播图时，自动播放停止，

window.addEventListener('load', function () {
    //引入的js在页面加载时执行。

    //获取元素
    var arrow_l = document.querySelector('.arrow-l');
    var arrow_r = document.querySelector('.arrow-r');
    var focus = document.querySelector('.focus');
    focus.addEventListener('mouseenter', function () {
        //鼠标经过显示左右按钮
        arrow_l.style.display = 'block';
        arrow_r.style.display = 'block';
    })
    focus.addEventListener('mouseleave', function () {
        //鼠标经过显示左右按钮
        arrow_l.style.display = 'none';
        arrow_r.style.display = 'none';
    })
    //3 动态生成小圆圈，数目与图片数量一致
    var ul = focus.querySelector('ul');
    var ol = focus.querySelector('.circle');
    // console.log(ul.children.length);
    for (var i = 0; i < ul.children.length; i++) {
        var li = document.createElement('li');
        ol.appendChild(li);
    }
    //选中第一个li为current类型
    ol.children[0].className = 'current';
})