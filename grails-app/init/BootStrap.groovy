import org.magaroni.City
import org.magaroni.Item
import org.magaroni.conftype.TimeUnit

class BootStrap {

    def init = { servletContext ->
        initDataBase()

    }
    def destroy = {
    }


    def initDataBase() {
        def cities = initCity()
        initItem(cities)
        //initUser()
    }

    def initCity() {
        /*
        * {label:"北京Beijing010",name:"北京",pinyin:"Beijing",zip:"010"},
            {label:"重庆Chongqing023",name:"重庆",pinyin:"Chongqing",zip:"023"},
            {label:"上海Shanghai021",name:"上海",pinyin:"Shanghai",zip:"021"},
         */
        //City beijing = new City(zip: "010", pinyin: "Beijing", name: "北京")
        //beijing.save(false)

        //City shanghai = new City(zip:  "021", pinyin:  "Shanghai", name: "上海")
        //shanghai.save(false)

        City chongqing = new City(zip: "023", pinyin:  "Chongqing", name:  "重庆")
        chongqing.save(false)
        flush: true

        return chongqing
    }

    def initItem(def city) {
        Item item = new Item(name: "催乳", serviceDuration: 45, serviceDurationUnit: TimeUnit.MINS,
                effect: "刺激乳腺分泌乳汁,增加奶量,以使婴儿有足够的奶水吃.",
                juniorPrice: 145.0, middlePrice: 245.0, seniorPrice: 500.0,
                juniorOriginPrice: 200.0, middleOriginPrice: 350.0, seniorOriginPrice: 800.0,
                feature: "无", symptom: "无奶水,奶水少", forbiddenSymptom: "易受刺激人群,丰胸者,心脏病人",
                additionalService: "指导母乳喂养好处,姿势,婴儿抱法等",
                pic: "/imgpath/somepath.jpg"
        )
        item.city = city

        item.save(false)
        flush: true

    }
}
