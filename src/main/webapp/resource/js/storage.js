const storage={
    // 设置localStorage
    set(key,item){
        let setItem = {
            token:item, // 缓存的数据
            effectiveTime: 1800000, // 有效时间
            startTime:new Date().getTime() // 当前时间作为起始时间
        }
        let storageItem = {}
        try{            
            storageItem = JSON.stringify(setItem);// 先用JSON.stringify转一下
        }catch(error){
            storageItem = setItem; // 如果不行就不是对象或者数组对象的类型，就直接赋值
        }
        localStorage.setItem(key,storageItem)
    },
    // 获取localStorage
    get(key){
        let getItem = localStorage.getItem(key)
        if(!getItem) return getItem
        try{
            getItem = JSON.parse(getItem);
            let currentTime = new Date().getTime();
            if(currentTime - getItem.startTime > getItem.effectiveTime){ //何时将值取出减去刚存入的时间，与item.effectiveTime比较，如果大于就是过期了，如果小于或等于就还没过期
                localStorage.removeItem(key); //缓存过期，清除缓存，返回false
                return false;
            }else{//缓存未过期，返回值
                return getItem;
            }
        }catch(error){//如果不行就不是json的字符串，就直接返回
            getItem = getItem;
        }

    },
    // 移除localStorage
    remove(key){
        localStorage.removeItem(key)
    }
}
export default storage
