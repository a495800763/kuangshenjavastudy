function animation(obj, target,callback) {
    //先清除之前的定时器，再开启定时器，同一时间只有一个定时器在移动obj，解决重复点按btn,obj移动速度加快的bug
    clearInterval(obj.timer);
    //注意这种写法，将定时器id写在obj中，作为其属性，利用已经开辟的obj对象的空间，而不是单独开辟储存id的空间
    obj.timer = window.setInterval(function () {
        // 获取元素当前位置
        var currentleft = obj.offsetLeft;
        //每次移动距离（速度）慢慢变小,step 当前移动距离(速度)
        //当前步长=（目标位置-当前位置）/ 份数（自定义份数）
        //var step = 1;
        //份数越大移动越快，太快的话看不出速度逐渐减小的平滑减速过程，份数越小移动越慢，越平缓，太平缓太慢
        // 因此份数一般定义成10
        //步长值往上取整，避免小数，避免回退
        //【下式支持负数步长，即回退】
        // var step = Math.ceil((target - obj.offsetLeft) / 10);
        var step = (target - obj.offsetLeft) / 10;
        step = step > 0 ? Math.ceil(step) : Math.floor(step);
        if(obj.offsetLeft==target){
            //定时器关闭时，执行回调函数
            if(callback){
                callback();
            }
            clearInterval(obj.timer);
        }
        obj.style.left = (currentleft + step) + 'px';

    }, 15)
}