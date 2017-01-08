package com.dianping.voice.data;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by andrew on 17/1/2.
 */

public class DataLibrary {

    public static List<String> dataInfo = new ArrayList<>();
    public static Map<String, String > imgUrls = new HashMap<String,String>();
    public static char[] stopWords = new char[]{'，','。','；','？',',',',',';'};
    public static Map<String, Long> picFileNames = new HashMap<>();
    private static Random random = new Random();
    public static String voicer = "xiaoqi";
    private static String ROOT_PATH = "/sdcard/DCIM/Camera/";
    static {

        File filePath = new File(ROOT_PATH);
        File[] fileNames = filePath.listFiles();
        for (File f: fileNames) {
            if (f.getName().endsWith("jpg")) {
                picFileNames.put(f.getName(),f.lastModified());
            }
        }

        dataInfo.add("霸王龙:是生存于白垩纪末期的马斯特里赫特阶距今约6850万年到6500万年的白垩纪最末期");
        imgUrls.put("霸王龙","http://www.94677.com/uploads/allimg/160529/09391C456-1.jpg");
        dataInfo.add("三角龙:是一种中等大小的四足恐龙，全长6—8米、高2.4-2.8米、重5—10吨");
        imgUrls.put("三角龙","http://imgsrc.baidu.com/baike/pic/item/7af40ad162d9f2d342a11c84adec8a136327cc2c.jpg");
        dataInfo.add("剑龙:为一种巨大的草食性恐龙，是一种生存在侏罗纪晚期的食草性动物，它的背上有一排巨大的骨质板，以及带有四根尖刺的危险尾巴来防御掠食者的攻击，大约7-9米长，2.35米至3.5米高，2至4吨重");
        imgUrls.put("剑龙","http://imgsrc.baidu.com/baike/pic/item/72f082025aafa40f63b33e80af64034f78f01971.jpg");
        dataInfo.add("异特龙:是种典型的大型兽脚类恐龙，拥有大型头颅骨、粗壮的颈部、长尾巴、以及缩短的前肢");
        imgUrls.put("","");

        dataInfo.add("马门溪龙:是中国发现的最大的蜥脚类恐龙之一，在宜宾市马鸣溪渡口发现其化石，经科学鉴定，属蜥脚类亚马目”。");
        imgUrls.put("","");
        dataInfo.add("包头龙:属(Lambe, 1910)是甲龙科下的一个属，又名优头甲龙，是甲龙科下最巨大的恐龙之一，体型与细小的象相若");
        imgUrls.put("","");
        dataInfo.add("上龙:是一种已灭绝海生爬行动物，属于上龙科，生存于侏罗纪晚期。上龙是一种大型掠食性动物，以鱼类、鱿鱼、以及其他海生爬行动物为食");
        imgUrls.put("","");
        dataInfo.add("棘龙:意思为「有棘的蜥蜴」，是一类大型兽脚类肉食龙,其中的亚种埃及棘龙是目前已知最大的食肉恐龙，体长12-19.6米，臀高270至480厘米，体重4-18吨");
        imgUrls.put("","");
        dataInfo.add("圆顶龙:是北美地区最著名的恐龙之一，它们生活于晚侏罗纪时期开阔的平原上，距今约155—145百万年前，在" +
                "1997年及1998年在美国怀俄明州发现两头成年圆顶龙及一头12.2米长的幼龙");
        imgUrls.put("","");
        dataInfo.add("板龙:意为平板的爬行动物，是生存于2亿1000万年前，晚三叠纪的古老恐龙。体长6－8米，身高3.6米，体重5吨左右");
        dataInfo.add("大椎龙:又名巨椎龙，属名在希腊文意为「巨大的脊椎」。大椎龙是原蜥脚下目的一属，生存于早侏罗纪赫塘阶到普林斯巴赫阶，约2亿年前到1亿8300万年前");
        dataInfo.add("棱背龙:身长不超过一辆汽车的长度，头部小小的，相较之下颈部的长度在所有装甲恐龙中算是较长的了");
        dataInfo.add("鲸龙:是发现得最早的恐龙之一。1841年，人们以零星发现的牙齿和骨头命名。1870年，一具不完整的骨骼在英国牛津附近被发现。");
        dataInfo.add("莱索托龙:是鸟臀目恐龙的一个属。它是由古生物学家彼得·加尔东（Peter M. Galton）在1978年命名，属名意思为“莱索托的蜥蜴”");
        dataInfo.add("小盾龙:意为“有小盾的蜥蜴”，是草食性恐龙的一属，生存于早侏罗纪的北美洲，约2亿年前到1亿9600万年前。小盾龙被分类于装甲亚目，是该亚目最早期的物种之一");
        dataInfo.add("蜀龙:是种独特的蜥脚下目恐龙，生存于晚侏罗世的中国四川省，约1亿7000万年前。蜀龙的属名来自于四川省的古名“蜀”");
        dataInfo.add("异齿龙:是二叠纪时期的肉食性古生物，一般大众将异齿龙联想是恐龙的一份子，但异齿龙其实并不是恐龙。更确切地说，它们被归类为盘龙目");
        dataInfo.add("华阳龙:是种存活于中侏罗纪中国的剑龙下目恐龙。华阳龙的名称来自于发现地四川省的别名“华阳”。华阳龙生存于1亿6500万年前");
        dataInfo.add("沱江龙:与同时代生活在北美洲的剑龙有着极其密切的亲缘关系。沱江龙从脖子、背脊到尾部，生长着15对三角形的背板，比剑龙的背板还要尖利");
        dataInfo.add("肯龙:生活在一亿三千七百万年前，是剑龙类的一种。头小体长，后腿比前腿长。背脊前部有两排三角形的骨板，后部有两排骨质刺棒。如果遇上食肉恐龙来侵犯，它会挥动尾巴，用刺棒回击");
        dataInfo.add("巴洛龙:又译“重型龙”，学名意思是“笨重的蜥蜴”。其化石是1912年美国化石采集家厄尔·道格拉斯在美国犹他州的卡内基采掘场挖出的。巴洛龙与近亲梁龙很像");
        dataInfo.add("梁龙:是梁龙科下的一属恐龙，它的骨骼化石首先由威利斯顿所发现。梁龙生活于侏罗纪末的北美洲西部");
        dataInfo.add("雷龙:又叫迷惑龙，梁龙科迷惑龙属，包括埃阿斯迷惑龙（A. ajax）和路氏迷惑龙（A. louisae）。重量达30吨");
        dataInfo.add("腕龙:是蜥脚下目的一属恐龙，生活于晚侏罗纪，它的名字是由古希腊文的（前臂）及（蜥蜴）结合而来，因它的前肢比起后肢大很多。腕龙是曾经生活在陆地上的最大的动物之一，亦是所有最有名的恐龙之一");
        dataInfo.add("橡树龙:1894年命名，原意是oak lizard 侏罗纪晚期 发掘于美国中西部、英国等 ，橡树龙科 长3.5米 100公斤。橡树龙是一种食草性恐龙，有可能是群居的");
        dataInfo.add("弯龙:体形庞大，与禽龙极为相似，头骨小，前肢短，后肢长，可四足行走。弯龙是禽龙的近亲。由于身体笨重，它可能行动迟缓");
        dataInfo.add("鹦鹉龙:译鹦鹉龙,在希腊文意为“鹦鹉蜥蜴”,是角龙下目鹦鹉嘴龙科的一属,生存早白垩纪的亚洲,约1亿2320万年前到1亿1000万年前");
        dataInfo.add("禽龙:属于蜥形纲鸟臀目鸟脚下目的禽龙类。禽龙是种大型鸟脚类恐龙");
        dataInfo.add("棱齿龙:是中等大小、身体很轻的陆生双足动物。上颚前部齿和特别长的朝向后方的公共杆显出其原始性。臼齿具切割作用，排列成单列，且3颗一组地更新。");
        dataInfo.add("尾羽龙:分类上属于美颌龙科的中华龙鸟、镰刀龙超科的北票龙和驰龙科的中国鸟龙都发育有类似鸟类绒羽的细丝状皮肤衍生物");
        dataInfo.add("镰刀龙:是一种植食恐龙，属于兽脚亚目中的虚骨龙类、手盗龙类。是兽脚类恐龙当中为数不多的素食者。生活在8000~7500万年前的蒙古。");
        dataInfo.add("慢龙:是一种兽脚类恐龙。但随着研究的不断深入，他们却对这种恐龙感到越来越疑惑，尤其是慢龙骨盆的出现，更让他们对慢龙的分类产生了疑问");
        dataInfo.add("甲龙:是甲龙科下的一属，当中只有一种，称为大面甲龙。甲龙的化石是在北美洲西部的地层被发现，年代属于白垩纪末期");
        dataInfo.add("原角龙:在希腊文意为“第一个有角的脸， 是种角龙下目恐龙，生存于上白垩纪坎潘阶的蒙古。原角龙属于原角龙科，原角龙科是一群早期角龙类");
        dataInfo.add("厚鼻龙:意为“有厚鼻的蜥蜴”，是鸟臀目角龙下目恐龙的一属，生存于晚白垩纪的北美洲");
        dataInfo.add("戟龙:又名刺盾角龙，在希腊文意为“有尖刺的蜥蜴”，是草食性角龙下目恐龙的一属，生存于白垩纪坎潘阶，约7650万年前到7500万年前");
        dataInfo.add("剑角龙:可不是个好惹的家伙。这种两足行走的食草动物来自一个不同寻常的恐龙家族：肿头龙家族共同的特征是都长有一块又厚又圆的头盖骨。它呈半圆形，由许多小骨块组成，盖住了它的眼睛和后脖颈");
        dataInfo.add("冥河龙:事实上是亚成年肿头龙。冥河龙，全长约2.4米，高约1米，体型和习性都很像野山羊，是一种头颅顶部、后部与口鼻部饰以非常发达的骨板与棘状物的神秘恐龙");
        dataInfo.add("肿头龙:生活在六千七百万年前，体长5米左右，头顶肿大，好像长着一个巨瘤，用两条粗壮的后腿走路，是鸟脚类恐龙的一种。脸部与口部饰以角质或骨质突起的棘状物或肿瘤");
        dataInfo.add("盔龙:又名冠龙、鸡冠龙、盔头龙或盔首龙，意为“头盔蜥蜴”，是鸭嘴龙科赖氏龙亚科下的一属，生活于上白垩纪的北美洲，约7500万年前");
        dataInfo.add("慈母龙:含义是“好妈妈蜥蜴”。1979年在美国蒙大拿，科学家们发现了一些恐龙窝，其中有小恐龙的骨架。于是他们把这种恐龙命名为慈母龙");
        dataInfo.add("鸭嘴龙:为一类较大型的鸟臀类恐龙，最大的有15米多长。是白垩纪后期鸟盘目草食性恐龙家族的其中一员。2008年居然发现了身长超过22米的鸭嘴龙");
        dataInfo.add("副龙栉龙:意为“几乎有冠饰的蜥蜴”，是鸭嘴龙科的一属，生存于晚白垩纪的北美洲，约7,600万年到7,300万年前");
        dataInfo.add("兰伯龙:意为“赖博蜥蜴”，是鸭嘴龙科的一属，生存于晚白垩纪的北美洲，约7,600万年前到7,500万年前。赖氏龙是草食性恐龙");
        dataInfo.add("结节龙:的头部与身体满覆瘤状骨板；钉状起分布于体侧。尾端没有锤状突起。从外形上看，它倒更像剑龙。它的背拱起，身体滚圆，头部细小，四肢粗壮");


        dataInfo.add("聪明:吃肉的恐龙很聪明，吃草的恐龙都很笨的");
        dataInfo.add("于盎然:是一个很喜欢动脑筋的小朋友，喜欢踢足球，打篮球，画画，骑车，最喜欢恐龙了");
        dataInfo.add("六一幼儿园:真好玩，我们一起唱歌，一起跳舞，一起学本领");
        dataInfo.add("柳琦童:是我的好朋友");
        dataInfo.add("吃饭:早上吃稀饭不错，中午吃牛肉，晚上吃面，我现在最喜欢吃牛肉，我要慢慢喜欢吃鱼和虾，爸爸妈妈说吃鱼的小孩是最聪明的。");
        dataInfo.add("我爱爸爸:爸爸是我的好朋友，爸爸开发的智能机器人很搞笑的，我问什么它都知道，可厉害了。");
        dataInfo.add("我爱妈妈:妈妈是我的好朋友");
        dataInfo.add("我是一个好孩子，好好学习，好好吃饭");
        dataInfo.add("豆包:喜欢吃鱼，豆包很听话，我喜欢豆包");
        dataInfo.add("小一班:总共有33个小朋友，我的好朋友是柳琦童，周瑾宣，张佳琪，郑程匀");
        dataInfo.add("豆包:喜欢吃鱼，豆包很听话，我喜欢豆包");
        dataInfo.add("上海地铁16号线:龙阳路 - 华夏中路 - 罗山路 - 周浦东 - 鹤沙航城 - 航头东 - 新场 - 野生动物园 - 惠南 - 惠南东 - 书院 - 临港大道 - 滴水湖");
        imgUrls.put("上海地铁16号线","http://imgsrc.baidu.com/forum/w%3D580/sign=2a2fddf5442309f7e76fad1a420f0c39/c65c10385343fbf2d7746e42b27eca8065388f73.jpg");
        dataInfo.add("上海地铁10号线:航中路 - 紫藤路 - 龙柏新村 - 虹桥火车站 - 虹桥2号航站楼 - 虹桥1号航站楼 - 上海动物园 - 龙溪路 - 水城路 - 伊犁路 - 宋园路 - 虹桥路 - 交通大学 - 上海图书馆 - 陕西南路 - 新天地 - 老西门 - 豫园 - 南京东路 - 天潼路 - 四川北路 - 海伦路 - 邮电新村 - 四平路 - 同济大学 - 国权路 - 五角场 - 江湾体育场 - 三门路 - 殷高东路 - 新江湾城 ");
        imgUrls.put("","");
        dataInfo.add("上海地铁11号线:花桥 - 光明路 - 兆丰路 - 安亭 - 上海汽车城 - 昌吉东路 - 上海赛车场 - 嘉定北 - 嘉定西 - 白银路 - 嘉定新城 - 马陆 - 南翔 - 桃浦新村 - 武威路 - 祁连山路 - 李子园 - 上海西站 - 真如 - 枫桥路 - 曹杨路 - 隆德路 - 江苏路 - 交通大学 - 徐家汇 - 上海游泳馆 - 龙华 - 云锦路 - 龙耀路 - 东方体育中心 - 三林 - 三林东 - 浦三路 - 御桥 - 罗山路 - 秀沿路 - 康新公路 - 迪士尼 ");
        dataInfo.add("上海地铁12号线:七莘路 - 虹莘路 - 顾戴路 - 东兰路 - 虹梅路 - 虹漕路 - 桂林公园 - 漕宝路 - 龙漕路 - 龙华 - 龙华中路 - 大木桥路 - 嘉善路 - 陕西南路 - 南京西路 - 汉中路 - 曲阜路 - 天潼路 - 国际客运中心 - 提篮桥 - 大连路 - 江浦公园 - 宁国路 - 隆昌路 - 爱国路 - 复兴岛 - 东陆路 - 巨峰路 - 杨高北路 - 金京路 - 申江路 - 金海路 ");
        dataInfo.add("上海地铁13号线:金运路 - 金沙江西路 - 丰庄 - 祁连山南路 - 真北路 - 大渡河路 - 金沙江路 - 隆德路 - 武宁路 - 长寿路 - 江宁路 - 汉中路 - 自然博物馆 - 南京西路 - 淮海中路 - 新天地 - 马当路 - 世博会博物馆 - 世博大道 ");
        dataInfo.add("上海地铁9号线:松江南站 - 醉白池 - 松江体育中心 - 松江新城 - 松江大学城 - 洞泾 - 佘山 - 泗泾 - 九亭 - 中春路 - 七宝 - 星中路 - 合川路 - 漕河泾开发区 - 桂林路 - 宜山路 - 徐家汇 - 肇嘉浜路 - 嘉善路 - 打浦桥 - 马当路 - 陆家浜路 - 小南门 - 商城路 - 世纪大道 - 杨高中路");
        dataInfo.add("上海地铁8号线:沈杜公路 - 联航路 - 江月路 - 浦江镇 - 芦恒路 - 凌兆新村 - 东方体育中心 - 杨思 - 成山路 - 耀华路 - 中华艺术宫 - 西藏南路 - 陆家浜路 - 老西门 - 大世界 - 人民广场 - 曲阜路 - 中兴路 - 西藏北路 - 虹口足球场 - 曲阳路 - 四平路 - 鞍山新村 - 江浦路 - 黄兴路 - 延吉中路 - 黄兴公园 - 翔殷路 - 嫩江路 - 市光路 ");
        dataInfo.add("上海地铁6号线:东方体育中心 - 灵岩南路 - 上南路 - 华夏西路 - 高青路 - 东明路 - 高科西路 - 临沂新村 - 上海儿童医学中心 - 蓝村路 - 浦电路 - 世纪大道 - 源深体育中心 - 民生路 - 北洋泾路 - 德平路 - 云山路 - 金桥路 - 博兴路 - 五莲路 - 巨峰路 - 东靖路 - 五洲大道 - 洲海路 - 外高桥保税区南 - 航津路 - 外高桥保税区北 - 港城路 ");
        dataInfo.add("上海地铁5号线:莘庄 - 春申路 - 银都路 - 颛桥 - 北桥 - 剑川路 - 东川路 - 金平路 - 华宁路 - 文井路 - 闵行开发区 ");
        dataInfo.add("上海地铁4号线:上海体育馆 - 宜山路 - 虹桥路 - 延安西路 - 中山公园 - 金沙江路 - 曹杨路 - 镇坪路 - 中潭路 - 上海火车站 - 宝山路 - 海伦路 - 临平路 - 大连路 - 杨树浦路 - 浦东大道 - 世纪大道 - 浦电路 - 蓝村路 - 塘桥 - 南浦大桥 - 西藏南路 - 鲁班路 - 大木桥路 - 东安路 - 上海体育场 ");
        dataInfo.add("上海地铁3号线:上海南站 - 石龙路 - 龙漕路 - 漕溪路 - 宜山路 - 虹桥路 - 延安西路 - 中山公园 - 金沙江路 - 曹杨路 - 镇坪路 - 中潭路 - 上海火车站 - 宝山路 - 东宝兴路 - 虹口足球场 - 赤峰路 - 大柏树 - 江湾镇 - 殷高西路 - 长江南路 - 淞发路 - 张华浜 - 淞滨路 - 水产路 - 宝杨路 - 友谊路 - 铁力路 - 江杨北路 ");
        imgUrls.put("","");
        dataInfo.add("海底总动员故事主要叙述一只过度保护儿子的小丑鱼马林和它在路上碰到的蓝唐王鱼多莉两人一同在汪洋大海中寻找玛林失去的儿子尼莫的奇幻经历。在路途中，玛林渐渐了解到它必须要勇于冒险以及它的儿子已经有能力照顾自己了");
        dataInfo.add("上海地铁1号线:富锦路,友谊西路,宝安公路,共富新村,呼兰路,通河新村,共康路,彭浦新村,汶水路,上海马戏城,延长路,中山北路,上海火车站,汉中路,新闸路,人民广场,黄陂南路,陕西南路,常熟路,衡山路,徐家汇,上海体育馆,漕宝路,上海南站,锦江乐园,莲花路,外环路,莘庄");
        imgUrls.put("","");
        dataInfo.add("上海地铁2号线:徐泾东,虹桥火车站,虹桥2号航站楼,淞虹路,北新泾,威宁路,娄山关路,中山公园,江苏路,静安寺,南京西路,人民广场,南京东路,陆家嘴,东昌路,世纪大道,上海科技馆,世纪公园,龙阳路,张江高科,金科路,广兰路,唐镇,创新中路,华夏东路,川沙,凌空路,远东大道,海天三路,浦东国际机场");
        imgUrls.put("上海地铁2号线","http://img2.imgtn.bdimg.com/it/u=2747347645,2734896635&fm=23&gp=0.jpg");
        dataInfo.add("上海地铁7号线:花木路,龙阳路,芳华路,锦绣路,杨高南路,高科西路,云台路,耀华路,长清路,后滩,龙华中路,东安路,肇嘉浜路,常熟路,静安寺,昌平路,长寿路,镇坪路,岚皋路,新村路,大华三路,行知路,大场镇,场中路,上大路,南陈路,上海大学,祁华路,顾村公园,刘行,潘广路,罗南新村,美兰湖");
        imgUrls.put("上海地铁7号线","http://img1.gtimg.com/2010/pics/19019/19019427.jpg");
        dataInfo.add("萨尔塔龙:又名索他龙，意为“萨尔塔省的蜥蜴”，是种蜥脚下目恐龙，生存于晚白垩纪。萨尔塔龙在蜥脚类恐龙当中相当小，但对人类而言还是很巨大");
        dataInfo.add("阿拉莫龙:又译阿拉莫龙，是萨尔塔龙科下的一阿拉摩龙阿拉摩龙个属，生活于上白垩纪的北美洲。它是一只大型的四足的草食性恐龙，身长达30米及体重达105公吨");
        dataInfo.add("阿根廷龙:属于蜥脚类恐龙的泰坦龙类， 命名十分简单， 意思是在阿根廷发现的恐龙。生存年代： 1亿年前白垩纪中期阿尔布阶-9300万年前白垩纪晚期森诺曼阶。");
        dataInfo.add("始盗龙:是最原始的一种。1993年，始盗龙发现于南美洲阿根廷西北部一处极其荒芜不毛之地——伊斯巨拉斯托盆地，该地属于三叠纪晚期地层");
        dataInfo.add("腔骨龙:又名虚形龙，是北美洲的小型、肉食性、双足恐龙，也是已知最早的恐龙之一。它首先出现于三叠纪晚期的诺利阶。");
        dataInfo.add("双脊龙:长约6米，体重达半吨，身高约2·4米。它的化石是在美国亚利桑那州图巴市西面的纳瓦荷印第安保留区中被发现。在发现骨头化石的几十呎之下，发现有大型肉食");
        dataInfo.add("冰脊龙:又名冰棘龙或冻角龙，是一类大型的双足兽脚亚目恐龙，在其头部有一个像西班牙梳的奇异冠状物。由于它的头冠像1950年代埃尔维斯·皮礼士利");
        dataInfo.add("气龙:是兽脚亚目（Theropoda）、肉食龙次亚目（Carnosauria）、巨齿龙科（Megalosauridae）的一属。肉食性，体长约3.5米，体重约150公斤");
        dataInfo.add("巨齿龙:最早被命名的恐龙，但生活的时期却是在侏罗纪。早在1677年，就有一位英国牧师对它的零星骨骼进行了描述，可惜那位牧师并不知道何种动物会有如此之大的骨骼，便把它说成是“巨人”的遗骨");
        dataInfo.add("始祖鸟:是一种生活在侏罗纪晚期的小型恐龙,隶属于恐爪龙下目,代表了一种恐爪龙类的原始类型");
        dataInfo.add("轻龙:长得又瘦又长，因而跑得很快，活像一只猎豹，只不过它是用两条后腿跑动的。它于侏罗纪晚期生活在东非坦桑尼");
        dataInfo.add("嗜鸟龙:意为“偷鸟类者”，是种小型兽脚亚目恐龙，生存于晚侏罗纪的劳亚大陆西部，约为现在的北美洲。");
        dataInfo.add("角鼻龙:在侏罗纪晚期，很凶残的的食肉恐龙——角鼻龙，从外形上看，它与其他的食肉恐龙没有太大区别，都是大头，粗腰，长尾，双脚行走，前肢短小，上下颌强健，嘴里布满尖利而弯曲的牙齿");
        dataInfo.add("细颚龙:具有敏锐的目光，捕猎能力很强。靠着强健“苗条”的后腿，它可以跑得很快，并且能够突然加速去捕捉跑的最快的小动物。细颚龙比大多数恐龙都长得秀气。");
        dataInfo.add("异特龙:又名跃龙或异龙，是蜥臀目兽脚亚目肉食龙下目恐龙的一属。异特龙是种中型的二足、掠食性恐龙，身长8.5米，最大9.7米，体重1.5~3吨最重3.6吨。它们生存于晚侏罗纪");
        dataInfo.add("中华龙鸟:生存于距今年内1.4亿年的早白垩世。1996年在中国辽西热河生物群中发现它的化石");
        dataInfo.add("鲨齿龙:生存时代为白垩纪的阿尔布阶到土仑阶。鲨齿龙是种巨大的肉食性恐龙，也是目前发现最大的兽脚亚目和食肉恐龙之一，成年的估计可达14米，体重6吨到11.5吨。");
        dataInfo.add("重爪龙:原意属名为坚实的利爪，沃克氏重爪龙的爪子比较其体躯而言真是庞大,重爪龙属于食肉的兽脚类恐龙，以前肢有大的爪而得名。重爪龙发现于英国南部，与其它的食肉恐龙有很大差别");
        dataInfo.add("恐爪龙:是驰龙科恐龙的一属，身长约3.4米，生活于下白垩纪的阿普第阶中期至阿尔布阶早期，距今约1亿1500万-1亿800万年前。");
        dataInfo.add("棘背龙:是一类大型兽脚类肉食龙,其中的亚种埃及棘龙是目前已知最大的食肉恐龙，体长12-19.6米，臀高270至480厘米，体重4-18吨");
        dataInfo.add("伤齿龙:生存于晚白垩纪，约7500万年前到6500万年前，最初是因为它尖锐的牙齿而得名");
        dataInfo.add("窃蛋龙:是种小型兽脚亚目恐龙, 生存于白垩纪晚期，身长1.8到2.5米。大小如鸵鸟，长有尖爪、长尾，推测其运动能力很强，行动敏捷，");
        dataInfo.add("似鸟龙:意为“鸟类模仿者”，是种兽脚亚目恐龙，生存于晚白垩纪的北美洲。");
        dataInfo.add("牛头龙:是种原始甲龙科、牛头龙属恐龙，生存于白垩纪早期的北美洲。化石发现于蒙大拿州惠特兰郡，当地属于Cloverly组");
        dataInfo.add("迅猛龙:译迅猛龙、速龙、快盗龙，属名在拉丁文意为“敏捷的盗贼”，是蜥臀目兽脚亚目驰龙科恐龙的一属，大约生活于8,300万至7,000万年前");
        dataInfo.add("翼龙:是一种已经灭绝的爬行类动物，共有近100多个品种。尽管与恐龙生存的时代相同，但翼龙并不是恐龙。");


        dataInfo.add("最近一个月照片-1:葱葱的照片");
        dataInfo.add("最近二个月照片-2:葱葱的两个月照片");
        dataInfo.add("最近三个月照片-4:葱葱的照片");
        dataInfo.add("最近四个月照片-4:葱葱的照片");
        dataInfo.add("最近五个月照片-5:葱葱的照片");
        dataInfo.add("最近六个月照片-6:葱葱的照片");
        dataInfo.add("最近七个月照片-7:葱葱的照片");
        dataInfo.add("最近八个月照片-8:葱葱的照片");
        dataInfo.add("最近九个月照片-9:葱葱的照片");
        dataInfo.add("最近十个月照片-10:葱葱的照片");
        dataInfo.add("最近十一个月照片-11:葱葱的照片");
        dataInfo.add("最近一年照片-12:葱葱的照片");
        dataInfo.add("最近二年照片-24:葱葱的两年内照片");
        dataInfo.add("最近三年照片-36:葱葱的照片");
        dataInfo.add("小时候照片-60:葱葱的照片");


    }

    public DataLibrary() {

    }

    private static String replaceNum(String question) {
        String result = question;
        result = result.replace("一","1");
        result = result.replace("二","2");
        result = result.replace("三","3");
        result = result.replace("四","4");
        result = result.replace("五","5");
        result = result.replace("六","6");
        result = result.replace("七","7");
        result = result.replace("八","8");
        result = result.replace("九","9");
        return result;

    }

    private static void setVoicer(String question) {
        if (question.contains("小七")) {
            voicer = "xiaoqi";
        } else if (question.contains("小燕") || question.contains("晓燕")) {
            voicer = "xiaoyan";
        } else if (question.contains("小宇") || question.contains("小雨") ) {
            voicer = "xiaoyu";
        } else if (question.contains("小新") || question.contains("小心")) {
            voicer = "xiaoxin";
        }
    }

    public static String getAnswer(String question) {
        setVoicer(question);
//        question = replaceNum(question);

        String result = "你的问题难倒我了。";
        String subwayResult = "";
        question = question.replace("建龙","剑龙");
        int maxMatch = 0;
        for (String temp: dataInfo) {
            int match= commonNum(question, temp);
            if (match > maxMatch) {
                maxMatch = match;
                result =temp;
            }
            if (match>question.length()) {
                if (temp.startsWith("上海地铁")  && (!question.contains("地铁") || !question.contains("号线") )) {
                    if (temp.indexOf(":") >0 ) {
                        subwayResult += temp.substring(0, temp.indexOf(":")+1);
                    }
                }
            }

        }
        if (!"".equals(subwayResult)) {
            return subwayResult;
        } else {
            return result;
        }

    }

    public static String getAnswer(String question,String[] dataList) {

        String result = "";
        int maxMatch = 0;
        for (String temp: dataList) {

            int match= commonNum(question, temp);
            if (match > maxMatch) {

                maxMatch = match;
                result =temp;
            }
        }
        return result;
    }

    private static boolean isStopWords(char x) {
        for (char y: stopWords) {
            if (x == y) {
                return true;
            }
        }
        return false;
    }
    private static int commonNum(String que, String answer) {
        int num = 0;

        //1-gram
        for (char x: que.toCharArray()) {

            if (isStopWords(x)) {
                continue;
            }
            int i=0;
            int weight = 1;
            for (char y: answer.toCharArray()) {

                i++;

                if (i<= answer.indexOf(":")) {
                    weight = 3;
                } else {
                    weight = 1;
                }
                if (x == y) {
                    num += weight;
                    break;
                }
            }
        }

        //2-gram
        int len = que.length();
        for (int i=0; i< len-1; i++) {
            if (answer.contains((que.substring(i,i+2))) ) {
                num += 1;
            }

        }

        return  num;
    }

    public static String getImgUrl(String name) {
        if (name.contains("照片")) {
            int timeSpan = Integer.parseInt(name.substring(name.indexOf("-")+1));
            Date now = new Date();
            long curTime = now.getTime();
            List<String> matchPic = new ArrayList<>();
            long spanTimeBegin = timeSpan*30*24;
            spanTimeBegin *= 3600000;
            long spanTimeEnd = (timeSpan-1)*30*24;
            spanTimeEnd *= 3600000;
            for (Map.Entry<String,Long> entry: picFileNames.entrySet()) {
                if (entry.getValue() + spanTimeBegin >curTime && entry.getValue()+spanTimeEnd< curTime ) {
                    matchPic.add(entry.getKey());
                }
            }

            if (matchPic.size() > 0) {
                int r = random.nextInt(matchPic.size());
                int i=0;
                for (String e: matchPic) {
                    if (i == r) {
                        return "file://"+ROOT_PATH+e;
                    }
                    i++;
                }
            }


        }

        if (imgUrls.containsKey(name) ){
            return imgUrls.get(name);
        } else {
            int r = random.nextInt(picFileNames.size());
            int i=0;
            for (String e: picFileNames.keySet()) {
                if (i == r) {
                    return "file://"+ROOT_PATH+e;
                }
                i++;
            }
        }
        return "http://img3.imgtn.bdimg.com/it/u=556551570,1362883455&fm=23&gp=0.jpg";
    }



//    public static String getName(String query) {
//
//        String[] dragons = new String[]{"霸王龙","马门溪龙","上龙","剑龙","包头龙","三角龙","异特龙",
//                "剑龙","棘龙","圆顶龙","板龙","大椎龙","棱背龙","鲸龙","莱索托龙","小盾龙","蜀龙","异齿龙"
//        ,"华阳龙","沱江龙","肯龙","巴洛龙","梁龙","雷龙","腕龙","橡树龙","弯龙","鹦鹉龙","禽龙","棱齿龙"
//        ,"尾羽龙","镰刀龙","慢龙","甲龙","原角龙","厚鼻龙","戟龙","剑角龙","冥河龙","肿头龙","盔龙","慈母龙",
//                "鸭嘴龙","副龙栉龙","兰伯龙","结节龙",""};
//
//        return getAnswer(query, dragons);
//
//    }

}