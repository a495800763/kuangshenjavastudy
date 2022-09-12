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
    var focusWidth = focus.offsetWidth;
    focus.addEventListener('mouseenter', function () {
        //鼠标经过显示左右按钮
        arrow_l.style.display = 'block';
        arrow_r.style.display = 'block';
        window.clearInterval(intervalId)
    })
    focus.addEventListener('mouseleave', function () {
        //鼠标经过显示左右按钮
        arrow_l.style.display = 'none';
        arrow_r.style.display = 'none';
        intervalId = setInterval(function () {
            arrow_r.click();
        },2000)
    })
    //3 动态生成小圆圈，数目与图片数量一致
    var ul = focus.querySelector('ul');
    var ol = focus.querySelector('.circle');
    // console.log(ul.children.length);
    for (var i = 0; i < ul.children.length; i++) {
        var li = document.createElement('li');
        //通过自定义属性记录当前小圆圈的索引号
        li.setAttribute('index', i);
        //小圆圈排他思想，注册每个小圆圈的点击事件
        li.addEventListener('click', function () {
            for (var i = 0; i < ol.children.length; i++) {
                ol.children[i].className = '';
            }
            this.className = 'current';
            //点击小圆圈，移动ul

            //点击小圆圈后，拿到当前小圆圈的索引号
            var index = this.getAttribute('index');
            currentIndex=index;
            circle=index;
            animate(ul, -index * focusWidth)
        })
        ol.appendChild(li);
    }
    //选中第一个li为current类型
    ol.children[0].className = 'current';
    // 克隆第一张图片放到最后,深克隆
    var firstClone = ul.children[0].cloneNode(true);
    ul.appendChild(firstClone);
    //6 点击左右侧按钮，图片滚动一张
    var currentIndex = 0;
    var circle = 0;
    //向右按钮
    arrow_r.addEventListener('click', function () {
        if (currentIndex == focus.children.length) {
            ul.style.left = 0 + 'px';
            currentIndex = 0;
        }
        currentIndex++;
        animate(ul, -currentIndex * focusWidth);
        circle++;
        if (circle == 4) {
            circle = 0;
        }
        for (var i = 0; i < ol.children.length; i++) {
            ol.children[i].className = '';
        }
        ol.children[circle].className = 'current';
    });
    //向左按钮
    arrow_l.addEventListener('click', function () {
        if (currentIndex == 0) {
            ul.style.left = -(focus.children.length * focusWidth) + 'px';
            currentIndex = 4;
        }
        currentIndex--;
        animate(ul, -currentIndex * focusWidth);
        circle--;
        if(circle<0){
            circle=3;
        }
        for (var i = 0; i < ol.children.length; i++) {
            ol.children[i].className = '';
        }
        ol.children[circle].className = 'current';
        if (circle == 0) {
            circle = 4;
        }

    });

   var intervalId =  window.setInterval(function () {
        arrow_r.click();
    },2000)
})