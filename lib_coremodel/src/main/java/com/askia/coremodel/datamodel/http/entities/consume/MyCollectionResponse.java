package com.askia.coremodel.datamodel.http.entities.consume;

import java.util.List;

public class MyCollectionResponse {

    /**
     * total : 2
     * pages : 1
     * pageNum : 1
     * pageSize : 10
     * pageData : [{"id":"879676418244476928","cmStruId":"833740323652894720","cmContType":1,"contName":"朴素归因理论","imgUri":"/yunying/202108/b0026374bd324349b078291b01523250.jpg","cmFlId":"879676101851348992","cmFsId":"1","link":"","contAbs":"","cont":"%3Cp%3E1958%E5%B9%B4%EF%BC%8C%E6%B5%B7%E5%BE%B7%E5%9C%A8%E4%BB%96%E7%9A%84%E8%91%97%E4%BD%9C%E3%80%8A%E4%BA%BA%E9%99%85%E5%85%B3%E7%B3%BB%E5%BF%83%E7%90%86%E5%AD%A6%E3%80%8B%E4%B8%AD%EF%BC%8C%E4%BB%8E%E9%80%9A%E4%BF%97%E5%BF%83%E7%90%86%E5%AD%A6%E7%9A%84%E8%A7%92%E5%BA%A6%E6%8F%90%E5%87%BA%E4%BA%86%E5%BD%92%E5%9B%A0%E7%90%86%E8%AE%BA%EF%BC%8C%E8%AF%A5%E7%90%86%E8%AE%BA%E4%B8%BB%E8%A6%81%E8%A7%A3%E5%86%B3%E7%9A%84%E6%98%AF%E6%97%A5%E5%B8%B8%E7%94%9F%E6%B4%BB%E4%B8%AD%E4%BA%BA%E4%BB%AC%E5%A6%82%E4%BD%95%E6%89%BE%E5%87%BA%E4%BA%8B%E4%BB%B6%E7%9A%84%E5%8E%9F%E5%9B%A0%E3%80%82%E6%B5%B7%E5%BE%B7%E8%AE%A4%E4%B8%BA%E4%BA%BA%E6%9C%89%E4%BA%8C%E7%A7%8D%E5%BC%BA%E7%83%88%E7%9A%84%E5%8A%A8%E6%9C%BA%EF%BC%9A%E4%B8%80%E6%98%AF%E5%BD%A2%E6%88%90%E5%AF%B9%E5%91%A8%E5%9B%B4%E7%8E%AF%E5%A2%83%E4%B8%80%E8%B4%AF%E6%80%A7%E7%90%86%E8%A7%A3%E7%9A%84%E9%9C%80%E8%A6%81%EF%BC%9B%E4%BA%8C%E6%98%AF%E6%8E%A7%E5%88%B6%E7%8E%AF%E5%A2%83%E7%9A%84%E9%9C%80%E8%A6%81%E3%80%82%E4%B8%BA%E4%BA%86%E6%BB%A1%E8%B6%B3%E8%BF%99%E4%B8%A4%E7%A7%8D%E9%9C%80%E8%A6%81%EF%BC%8C%E6%99%AE%E9%80%9A%E4%BA%BA%E5%BF%85%E9%A1%BB%E8%A6%81%E5%AF%B9%E4%BB%96%E4%BA%BA%E7%9A%84%E8%A1%8C%E4%B8%BA%E8%BF%9B%E8%A1%8C%E5%BD%92%E5%9B%A0%EF%BC%8C%E5%B9%B6%E4%B8%94%E7%BB%8F%E8%BF%87%E5%BD%92%E5%9B%A0%E6%9D%A5%E9%A2%84%E6%B5%8B%E4%BB%96%E4%BA%BA%E7%9A%84%E8%A1%8C%E4%B8%BA%EF%BC%8C%E5%94%AF%E6%9C%89%E5%A6%82%E6%AD%A4%E6%89%8D%E6%9C%89%E5%8F%AF%E8%83%BD%E6%BB%A1%E8%B6%B3%26ldquo%3B%E7%90%86%E8%A7%A3%E7%8E%AF%E5%A2%83%E5%92%8C%E6%8E%A7%E5%88%B6%E7%8E%AF%E5%A2%83%26rdquo%3B%E7%9A%84%E9%9C%80%E8%A6%81%E3%80%82%3C%2Fp%3E%0A%3Cp%3E%E6%B5%B7%E5%BE%B7%E8%BF%98%E6%8C%87%E5%87%BA%EF%BC%8C%E5%9C%A8%E5%BD%92%E5%9B%A0%E7%9A%84%E6%97%B6%E5%80%99%EF%BC%8C%E4%BA%BA%E4%BB%AC%E7%BB%8F%E5%B8%B8%E4%BD%BF%E7%94%A8%E4%B8%A4%E4%B8%AA%E5%8E%9F%E5%88%99%EF%BC%9A%3C%2Fp%3E%0A%3Cp%3E%E4%B8%80%E6%98%AF%E5%85%B1%E5%8F%98%E5%8E%9F%E5%88%99%EF%BC%88Principle%20of%20covariation%EF%BC%89%EF%BC%8C%E5%AE%83%E6%98%AF%E6%8C%87%E6%9F%90%E4%B8%AA%E7%89%B9%E5%AE%9A%E7%9A%84%E5%8E%9F%E5%9B%A0%E5%9C%A8%E8%AE%B8%E5%A4%9A%E4%B8%8D%E5%90%8C%E7%9A%84%E6%83%85%E5%A2%83%E4%B8%8B%E5%92%8C%E6%9F%90%E4%B8%AA%E7%89%B9%E5%AE%9A%E7%BB%93%E6%9E%9C%E7%9B%B8%E8%81%94%E7%B3%BB%EF%BC%8C%E8%AF%A5%E5%8E%9F%E5%9B%A0%E4%B8%8D%E5%AD%98%E5%9C%A8%E6%97%B6%EF%BC%8C%E7%BB%93%E6%9E%9C%E4%B9%9F%E4%B8%8D%E5%87%BA%E7%8E%B0%EF%BC%8C%E6%88%91%E4%BB%AC%E5%B0%B1%E5%8F%AF%E4%BB%A5%E6%8A%8A%E7%BB%93%E6%9E%9C%E5%BD%92%E4%BA%8E%E8%AF%A5%E5%8E%9F%E5%9B%A0%EF%BC%8C%E8%BF%99%E5%B0%B1%E6%98%AF%E5%85%B1%E5%8F%98%E5%8E%9F%E5%88%99%E3%80%82%3C%2Fp%3E%0A%3Cp%3E%E4%BA%8C%E6%98%AF%E6%8E%92%E9%99%A4%E5%8E%9F%E5%88%99%EF%BC%8C%E5%AE%83%E6%98%AF%E6%8C%87%E5%A6%82%E6%9E%9C%E5%86%85%E5%A4%96%E5%9B%A0%E6%9F%90%E4%B8%80%E6%96%B9%E9%9D%A2%E7%9A%84%E5%8E%9F%E5%9B%A0%E8%B6%B3%E4%BB%A5%E8%A7%A3%E9%87%8A%E4%BA%8B%E4%BB%B6%EF%BC%8C%E6%88%91%E4%BB%AC%E5%B0%B1%E5%8F%AF%E4%BB%A5%E6%8E%92%E9%99%A4%E5%8F%A6%E4%B8%80%E6%96%B9%E9%9D%A2%E7%9A%84%E5%BD%92%E5%9B%A0%E3%80%82%3C%2Fp%3E%0A%3Cp%3E%26nbsp%3B%3C%2Fp%3E%0A%3Cp%3E%26nbsp%3B%3C%2Fp%3E%0A%3Cp%3E%26nbsp%3B%3C%2Fp%3E","source":"12355","contLabel":"","contentParentId":"879676418244476928","contentChildrenId":"","createTime":"2021-08-24 23:40:02","imgUrl":"http://cldscmsvideo.oss-cn-huhehaote-nebula-1.aliyuncs.com/ecb555dd5d0f4fd18d10b2a7869f97aa.jpg?Expires=1702884930&OSSAccessKeyId=LTAI5tE8k22tASfQeMbdKwo6&Signature=8Vm2EzuL6qv%2BmViyzUyfQN%2FpGvg%3D","audioListList":[{"id":"879676418273837056","contId":"879676418244476928","sort":1,"audioUrl":"http://cdlscmsaudio.oss-cn-huhehaote-nebula-1.aliyuncs.com/ea0c43f0fb1a46639244799c542e9839.mp3?Expires=1702884930&OSSAccessKeyId=LTAI5tE8k22tASfQeMbdKwo6&Signature=%2B7CrMhk3XU%2BVPLSo9CbcU%2B2BQic%3D","contTitle":"朴素归因理论","audioTimeLength":"77.80","contText":"朴素归因理论<p>1958年，海德在他的著作《人际关系心理学》中，从通俗心理学的角度提出了归因理论，该理论主要解决的是日常生活中人们如何找出事件的原因。海德认为人有二种强烈的动机：一是形成对周围环境一贯性理解的需要；二是控制环境的需要。为了满足这两种需要，普通人必须要对他人的行为进行归因，并且经过归因来预测他人的行为，唯有如此才有可能满足&ldquo;理解环境和控制环境&rdquo;的需要。<\/p>\n<p>海德还指出，在归因的时候，人们经常使用两个原则：<\/p>\n<p>一是共变原则（Principle of covariation），它是指某个特定的原因在许多不同的情境下和某个特定结果相联系，该原因不存在时，结果也不出现，我们就可以把结果归于该原因，这就是共变原则。<\/p>\n<p>二是排除原则，它是指如果内外因某一方面的原因足以解释事件，我们就可以排除另一方面的归因。<\/p>\n<p>&nbsp;<\/p>\n<p>&nbsp;<\/p>\n<p>&nbsp;<\/p>"}],"remark":"[]"},{"id":"879675908762370048","cmStruId":"833740323652894720","cmContType":3,"contName":"分工理论","imgUri":"/yunying/202108/4121f9afb692461fbf28ecd45d05370e.jpg","cmFlId":"879675685705089024","cmFsId":"1","link":"","contAbs":"","cont":"%3Cp%3E1776%E5%B9%B43%E6%9C%88%EF%BC%8C%E4%BA%9A%E5%BD%93%26middot%3B%E6%96%AF%E5%AF%86%E7%9A%84%E3%80%8A%E5%9B%BD%E5%AF%8C%E8%AE%BA%E3%80%8B%E4%B8%AD%E7%AC%AC%E4%B8%80%E6%AC%A1%E6%8F%90%E5%87%BA%E4%BA%86%E5%8A%B3%E5%8A%A8%E5%88%86%E5%B7%A5%E7%9A%84%E8%A7%82%E7%82%B9%EF%BC%8C%E5%B9%B6%E7%B3%BB%E7%BB%9F%E5%85%A8%E9%9D%A2%E5%9C%B0%E9%98%90%E8%BF%B0%E4%BA%86%E5%8A%B3%E5%8A%A8%E5%88%86%E5%B7%A5%E5%AF%B9%E6%8F%90%E9%AB%98%E5%8A%B3%E5%8A%A8%E7%94%9F%E4%BA%A7%E7%8E%87%E5%92%8C%E5%A2%9E%E8%BF%9B%E5%9B%BD%E6%B0%91%E8%B4%A2%E5%AF%8C%E7%9A%84%E5%B7%A8%E5%A4%A7%E4%BD%9C%E7%94%A8%E3%80%82%3C%2Fp%3E%0A%3Cp%3E%E4%BA%9A%E5%BD%93%26middot%3B%E6%96%AF%E5%AF%86%E8%AE%A4%E4%B8%BA%EF%BC%8C%E5%88%86%E5%B7%A5%E6%9C%89%E5%88%A9%E4%BA%8E%E5%8A%B3%E5%8A%A8%E7%94%9F%E4%BA%A7%E7%8E%87%E7%9A%84%E6%8F%90%E5%8D%87%E3%80%82%E5%88%86%E5%B7%A5%E7%9A%84%E8%B5%B7%E6%BA%90%E6%98%AF%E7%94%B1%E4%BA%8E%E4%BA%BA%E7%9A%84%E6%89%8D%E8%83%BD%E5%85%B7%E6%9C%89%E8%87%AA%E7%84%B6%E5%B7%AE%E5%BC%82%EF%BC%8C%E9%82%A3%E6%98%AF%E8%B5%B7%E5%9B%A0%E4%BA%8E%E4%BA%BA%E7%B1%BB%E7%8B%AC%E6%9C%89%E7%9A%84%E4%BA%A4%E6%8D%A2%E4%B8%8E%E6%98%93%E8%B4%A7%E5%80%BE%E5%90%91%EF%BC%8C%E4%BA%A4%E6%8D%A2%E5%8F%8A%E6%98%93%E8%B4%A7%E7%B3%BB%E5%B1%9E%E7%A7%81%E5%88%A9%E8%A1%8C%E4%B8%BA%EF%BC%8C%E5%85%B6%E5%88%A9%E7%9B%8A%E5%86%B3%E5%AE%9A%E4%BA%8E%E5%88%86%E5%B7%A5%EF%BC%8C%E5%81%87%E5%AE%9A%E4%B8%AA%E4%BA%BA%E4%B9%90%E4%BA%8E%E4%B8%93%E4%B8%9A%E5%8C%96%E5%8F%8A%E6%8F%90%E9%AB%98%E7%94%9F%E4%BA%A7%E5%8A%9B%EF%BC%8C%E7%BB%8F%E7%94%B1%E5%89%A9%E4%BD%99%E4%BA%A7%E5%93%81%E4%B9%8B%E4%BA%A4%E6%8D%A2%E8%A1%8C%E4%B8%BA%EF%BC%8C%E4%BF%83%E4%BD%BF%E4%B8%AA%E4%BA%BA%E5%A2%9E%E5%8A%A0%E8%B4%A2%E5%AF%8C%EF%BC%8C%E6%AD%A4%E7%AD%89%E8%BF%87%E7%A8%8B%E5%B0%86%E6%89%A9%E5%A4%A7%E7%A4%BE%E4%BC%9A%E7%94%9F%E4%BA%A7%EF%BC%8C%E4%BF%83%E8%BF%9B%E7%A4%BE%E4%BC%9A%E7%B9%81%E8%8D%A3%EF%BC%8C%E5%B9%B6%E8%BE%BE%E7%A7%81%E5%88%A9%E4%B8%8E%E5%85%AC%E7%9B%8A%E4%B9%8B%E8%B0%83%E5%92%8C%E3%80%82%3C%2Fp%3E%0A%3Cp%3E%E4%BB%96%E5%88%97%E4%B8%BE%E5%88%B6%E9%92%88%E4%B8%9A%E6%9D%A5%E8%AF%B4%E6%98%8E%E3%80%82%26ldquo%3B%E5%A6%82%E6%9E%9C%E4%BB%96%E4%BB%AC%E5%90%84%E8%87%AA%E7%8B%AC%E7%AB%8B%E5%B7%A5%E4%BD%9C%EF%BC%8C%E4%B8%8D%E4%B8%93%E4%B9%A0%E4%B8%80%E7%A7%8D%E7%89%B9%E6%AE%8A%E4%B8%9A%E5%8A%A1%EF%BC%8C%E9%82%A3%E4%B9%88%E4%BB%96%E4%BB%AC%E4%B8%8D%E8%AE%BA%E6%98%AF%E8%B0%81%EF%BC%8C%E7%BB%9D%E5%AF%B9%E4%B8%8D%E8%83%BD%E4%B8%80%E6%97%A5%E5%88%B6%E9%80%A0%E4%BA%8C%E5%8D%81%E6%9E%9A%E9%92%88%EF%BC%8C%E8%AF%B4%E4%B8%8D%E5%AE%9A%E4%B8%80%E5%A4%A9%E8%BF%9E%E4%B8%80%E6%9E%9A%E4%B9%9F%E5%88%B6%E9%80%A0%E4%B8%8D%E5%87%BA%E6%9D%A5%E3%80%82%E4%BB%96%E4%BB%AC%E4%B8%8D%E4%BD%86%E4%B8%8D%E8%83%BD%E5%88%B6%E5%87%BA%E4%BB%8A%E6%97%A5%E7%94%B1%E9%80%82%E5%BD%93%E5%88%86%E5%B7%A5%E5%90%88%E4%BD%9C%E8%80%8C%E5%88%B6%E6%88%90%E7%9A%84%E6%95%B0%E9%87%8F%E7%9A%84%E4%BA%8C%E7%99%BE%E5%9B%9B%E5%8D%81%E5%88%86%E4%B9%8B%E4%B8%80%EF%BC%8C%E5%B0%B1%E8%BF%9E%E8%BF%99%E6%95%B0%E9%87%8F%E7%9A%84%E5%9B%9B%E5%8D%83%E5%85%AB%E7%99%BE%E5%88%86%E4%B9%8B%E4%B8%80%EF%BC%8C%E6%81%90%E6%80%95%E4%B9%9F%E5%88%B6%E9%80%A0%E4%B8%8D%E5%87%BA%E6%9D%A5%E3%80%82%26rdquo%3B%3C%2Fp%3E%0A%3Cp%3E%E5%88%86%E5%B7%A5%E4%BF%83%E8%BF%9B%E5%8A%B3%E5%8A%A8%E7%94%9F%E4%BA%A7%E5%8A%9B%E7%9A%84%E5%8E%9F%E5%9B%A0%E6%9C%89%E4%B8%89%EF%BC%9A%3C%2Fp%3E%0A%3Cp%3E%E7%AC%AC%E4%B8%80%EF%BC%8C%E5%8A%B3%E5%8A%A8%E8%80%85%E7%9A%84%E6%8A%80%E5%B7%A7%E5%9B%A0%E4%B8%93%E4%B8%9A%E8%80%8C%E6%97%A5%E8%BF%9B%EF%BC%9B%3C%2Fp%3E%0A%3Cp%3E%E7%AC%AC%E4%BA%8C%EF%BC%8C%E7%94%B1%E4%B8%80%E7%A7%8D%E5%B7%A5%E4%BD%9C%E8%BD%AC%E5%88%B0%E5%8F%A6%E4%B8%80%E7%A7%8D%E5%B7%A5%E4%BD%9C%EF%BC%8C%E9%80%9A%E5%B8%B8%E9%9C%80%E6%8D%9F%E5%A4%B1%E4%B8%8D%E5%B0%91%E6%97%B6%E9%97%B4%EF%BC%8C%E6%9C%89%E4%BA%86%E5%88%86%E5%B7%A5%EF%BC%8C%E5%B0%B1%E5%8F%AF%E4%BB%A5%E5%85%8D%E9%99%A4%E8%BF%99%E7%A7%8D%E6%8D%9F%E5%A4%B1%EF%BC%9B%3C%2Fp%3E%0A%3Cp%3E%E7%AC%AC%E4%B8%89%EF%BC%8C%E8%AE%B8%E5%A4%9A%E7%AE%80%E5%8C%96%E5%8A%B3%E5%8A%A8%E5%92%8C%E7%BC%A9%E5%87%8F%E5%8A%B3%E5%8A%A8%E7%9A%84%E6%9C%BA%E6%A2%B0%E5%8F%91%E6%98%8E%EF%BC%8C%E5%8F%AA%E6%9C%89%E5%9C%A8%E5%88%86%E5%B7%A5%E7%9A%84%E5%9F%BA%E7%A1%80%E4%B8%8A%E6%96%B9%E6%89%8D%E5%8F%AF%E8%83%BD%E3%80%82%3C%2Fp%3E","source":"","contLabel":"","contentParentId":"879675908762370048","contentChildrenId":"","createTime":"2021-08-24 23:38:00","imgUrl":"http://cldscmsvideo.oss-cn-huhehaote-nebula-1.aliyuncs.com/e4218f31b30e4055ad480d621484da78.jpg?Expires=1702884930&OSSAccessKeyId=LTAI5tE8k22tASfQeMbdKwo6&Signature=AXBGE%2FP%2BBAmxNeBjBZt0YgY5C6Y%3D","audioListList":[{"id":"879675908791730176","contId":"879675908762370048","sort":1,"audioUrl":"http://cdlscmsaudio.oss-cn-huhehaote-nebula-1.aliyuncs.com/7429121143994d559f15bd65bfe45351.mp3?Expires=1702884930&OSSAccessKeyId=LTAI5tE8k22tASfQeMbdKwo6&Signature=md7mmDAELZRTMVteVrhYST%2Bpv5E%3D","contTitle":"分工理论","audioTimeLength":"108.43","contText":"分工理论<p>1776年3月，亚当&middot;斯密的《国富论》中第一次提出了劳动分工的观点，并系统全面地阐述了劳动分工对提高劳动生产率和增进国民财富的巨大作用。<\/p>\n<p>亚当&middot;斯密认为，分工有利于劳动生产率的提升。分工的起源是由于人的才能具有自然差异，那是起因于人类独有的交换与易货倾向，交换及易货系属私利行为，其利益决定于分工，假定个人乐于专业化及提高生产力，经由剩余产品之交换行为，促使个人增加财富，此等过程将扩大社会生产，促进社会繁荣，并达私利与公益之调和。<\/p>\n<p>他列举制针业来说明。&ldquo;如果他们各自独立工作，不专习一种特殊业务，那么他们不论是谁，绝对不能一日制造二十枚针，说不定一天连一枚也制造不出来。他们不但不能制出今日由适当分工合作而制成的数量的二百四十分之一，就连这数量的四千八百分之一，恐怕也制造不出来。&rdquo;<\/p>\n<p>分工促进劳动生产力的原因有三：<\/p>\n<p>第一，劳动者的技巧因专业而日进；<\/p>\n<p>第二，由一种工作转到另一种工作，通常需损失不少时间，有了分工，就可以免除这种损失；<\/p>\n<p>第三，许多简化劳动和缩减劳动的机械发明，只有在分工的基础上方才可能。<\/p>"}],"remark":"[]"}]
     * endRow : 0
     * startRow : 0
     */

    private int total;
    private int pages;
    private int pageNum;
    private int pageSize;
    private int endRow;
    private int startRow;
    private List<PageDataBean> pageData;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getEndRow() {
        return endRow;
    }

    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public List<PageDataBean> getPageData() {
        return pageData;
    }

    public void setPageData(List<PageDataBean> pageData) {
        this.pageData = pageData;
    }

    public static class PageDataBean {
        public boolean isTrueOrFalse() {
            return isTrueOrFalse;
        }

        public void setTrueOrFalse(boolean trueOrFalse) {
            isTrueOrFalse = trueOrFalse;
        }

        /**
         * id : 879676418244476928
         * cmStruId : 833740323652894720
         * cmContType : 1
         * contName : 朴素归因理论
         * imgUri : /yunying/202108/b0026374bd324349b078291b01523250.jpg
         * cmFlId : 879676101851348992
         * cmFsId : 1
         * link :
         * contAbs :
         * cont : %3Cp%3E1958%E5%B9%B4%EF%BC%8C%E6%B5%B7%E5%BE%B7%E5%9C%A8%E4%BB%96%E7%9A%84%E8%91%97%E4%BD%9C%E3%80%8A%E4%BA%BA%E9%99%85%E5%85%B3%E7%B3%BB%E5%BF%83%E7%90%86%E5%AD%A6%E3%80%8B%E4%B8%AD%EF%BC%8C%E4%BB%8E%E9%80%9A%E4%BF%97%E5%BF%83%E7%90%86%E5%AD%A6%E7%9A%84%E8%A7%92%E5%BA%A6%E6%8F%90%E5%87%BA%E4%BA%86%E5%BD%92%E5%9B%A0%E7%90%86%E8%AE%BA%EF%BC%8C%E8%AF%A5%E7%90%86%E8%AE%BA%E4%B8%BB%E8%A6%81%E8%A7%A3%E5%86%B3%E7%9A%84%E6%98%AF%E6%97%A5%E5%B8%B8%E7%94%9F%E6%B4%BB%E4%B8%AD%E4%BA%BA%E4%BB%AC%E5%A6%82%E4%BD%95%E6%89%BE%E5%87%BA%E4%BA%8B%E4%BB%B6%E7%9A%84%E5%8E%9F%E5%9B%A0%E3%80%82%E6%B5%B7%E5%BE%B7%E8%AE%A4%E4%B8%BA%E4%BA%BA%E6%9C%89%E4%BA%8C%E7%A7%8D%E5%BC%BA%E7%83%88%E7%9A%84%E5%8A%A8%E6%9C%BA%EF%BC%9A%E4%B8%80%E6%98%AF%E5%BD%A2%E6%88%90%E5%AF%B9%E5%91%A8%E5%9B%B4%E7%8E%AF%E5%A2%83%E4%B8%80%E8%B4%AF%E6%80%A7%E7%90%86%E8%A7%A3%E7%9A%84%E9%9C%80%E8%A6%81%EF%BC%9B%E4%BA%8C%E6%98%AF%E6%8E%A7%E5%88%B6%E7%8E%AF%E5%A2%83%E7%9A%84%E9%9C%80%E8%A6%81%E3%80%82%E4%B8%BA%E4%BA%86%E6%BB%A1%E8%B6%B3%E8%BF%99%E4%B8%A4%E7%A7%8D%E9%9C%80%E8%A6%81%EF%BC%8C%E6%99%AE%E9%80%9A%E4%BA%BA%E5%BF%85%E9%A1%BB%E8%A6%81%E5%AF%B9%E4%BB%96%E4%BA%BA%E7%9A%84%E8%A1%8C%E4%B8%BA%E8%BF%9B%E8%A1%8C%E5%BD%92%E5%9B%A0%EF%BC%8C%E5%B9%B6%E4%B8%94%E7%BB%8F%E8%BF%87%E5%BD%92%E5%9B%A0%E6%9D%A5%E9%A2%84%E6%B5%8B%E4%BB%96%E4%BA%BA%E7%9A%84%E8%A1%8C%E4%B8%BA%EF%BC%8C%E5%94%AF%E6%9C%89%E5%A6%82%E6%AD%A4%E6%89%8D%E6%9C%89%E5%8F%AF%E8%83%BD%E6%BB%A1%E8%B6%B3%26ldquo%3B%E7%90%86%E8%A7%A3%E7%8E%AF%E5%A2%83%E5%92%8C%E6%8E%A7%E5%88%B6%E7%8E%AF%E5%A2%83%26rdquo%3B%E7%9A%84%E9%9C%80%E8%A6%81%E3%80%82%3C%2Fp%3E%0A%3Cp%3E%E6%B5%B7%E5%BE%B7%E8%BF%98%E6%8C%87%E5%87%BA%EF%BC%8C%E5%9C%A8%E5%BD%92%E5%9B%A0%E7%9A%84%E6%97%B6%E5%80%99%EF%BC%8C%E4%BA%BA%E4%BB%AC%E7%BB%8F%E5%B8%B8%E4%BD%BF%E7%94%A8%E4%B8%A4%E4%B8%AA%E5%8E%9F%E5%88%99%EF%BC%9A%3C%2Fp%3E%0A%3Cp%3E%E4%B8%80%E6%98%AF%E5%85%B1%E5%8F%98%E5%8E%9F%E5%88%99%EF%BC%88Principle%20of%20covariation%EF%BC%89%EF%BC%8C%E5%AE%83%E6%98%AF%E6%8C%87%E6%9F%90%E4%B8%AA%E7%89%B9%E5%AE%9A%E7%9A%84%E5%8E%9F%E5%9B%A0%E5%9C%A8%E8%AE%B8%E5%A4%9A%E4%B8%8D%E5%90%8C%E7%9A%84%E6%83%85%E5%A2%83%E4%B8%8B%E5%92%8C%E6%9F%90%E4%B8%AA%E7%89%B9%E5%AE%9A%E7%BB%93%E6%9E%9C%E7%9B%B8%E8%81%94%E7%B3%BB%EF%BC%8C%E8%AF%A5%E5%8E%9F%E5%9B%A0%E4%B8%8D%E5%AD%98%E5%9C%A8%E6%97%B6%EF%BC%8C%E7%BB%93%E6%9E%9C%E4%B9%9F%E4%B8%8D%E5%87%BA%E7%8E%B0%EF%BC%8C%E6%88%91%E4%BB%AC%E5%B0%B1%E5%8F%AF%E4%BB%A5%E6%8A%8A%E7%BB%93%E6%9E%9C%E5%BD%92%E4%BA%8E%E8%AF%A5%E5%8E%9F%E5%9B%A0%EF%BC%8C%E8%BF%99%E5%B0%B1%E6%98%AF%E5%85%B1%E5%8F%98%E5%8E%9F%E5%88%99%E3%80%82%3C%2Fp%3E%0A%3Cp%3E%E4%BA%8C%E6%98%AF%E6%8E%92%E9%99%A4%E5%8E%9F%E5%88%99%EF%BC%8C%E5%AE%83%E6%98%AF%E6%8C%87%E5%A6%82%E6%9E%9C%E5%86%85%E5%A4%96%E5%9B%A0%E6%9F%90%E4%B8%80%E6%96%B9%E9%9D%A2%E7%9A%84%E5%8E%9F%E5%9B%A0%E8%B6%B3%E4%BB%A5%E8%A7%A3%E9%87%8A%E4%BA%8B%E4%BB%B6%EF%BC%8C%E6%88%91%E4%BB%AC%E5%B0%B1%E5%8F%AF%E4%BB%A5%E6%8E%92%E9%99%A4%E5%8F%A6%E4%B8%80%E6%96%B9%E9%9D%A2%E7%9A%84%E5%BD%92%E5%9B%A0%E3%80%82%3C%2Fp%3E%0A%3Cp%3E%26nbsp%3B%3C%2Fp%3E%0A%3Cp%3E%26nbsp%3B%3C%2Fp%3E%0A%3Cp%3E%26nbsp%3B%3C%2Fp%3E
         * source : 12355
         * contLabel :
         * contentParentId : 879676418244476928
         * contentChildrenId :
         * createTime : 2021-08-24 23:40:02
         * imgUrl : http://cldscmsvideo.oss-cn-huhehaote-nebula-1.aliyuncs.com/ecb555dd5d0f4fd18d10b2a7869f97aa.jpg?Expires=1702884930&OSSAccessKeyId=LTAI5tE8k22tASfQeMbdKwo6&Signature=8Vm2EzuL6qv%2BmViyzUyfQN%2FpGvg%3D
         * audioListList : [{"id":"879676418273837056","contId":"879676418244476928","sort":1,"audioUrl":"http://cdlscmsaudio.oss-cn-huhehaote-nebula-1.aliyuncs.com/ea0c43f0fb1a46639244799c542e9839.mp3?Expires=1702884930&OSSAccessKeyId=LTAI5tE8k22tASfQeMbdKwo6&Signature=%2B7CrMhk3XU%2BVPLSo9CbcU%2B2BQic%3D","contTitle":"朴素归因理论","audioTimeLength":"77.80","contText":"朴素归因理论<p>1958年，海德在他的著作《人际关系心理学》中，从通俗心理学的角度提出了归因理论，该理论主要解决的是日常生活中人们如何找出事件的原因。海德认为人有二种强烈的动机：一是形成对周围环境一贯性理解的需要；二是控制环境的需要。为了满足这两种需要，普通人必须要对他人的行为进行归因，并且经过归因来预测他人的行为，唯有如此才有可能满足&ldquo;理解环境和控制环境&rdquo;的需要。<\/p>\n<p>海德还指出，在归因的时候，人们经常使用两个原则：<\/p>\n<p>一是共变原则（Principle of covariation），它是指某个特定的原因在许多不同的情境下和某个特定结果相联系，该原因不存在时，结果也不出现，我们就可以把结果归于该原因，这就是共变原则。<\/p>\n<p>二是排除原则，它是指如果内外因某一方面的原因足以解释事件，我们就可以排除另一方面的归因。<\/p>\n<p>&nbsp;<\/p>\n<p>&nbsp;<\/p>\n<p>&nbsp;<\/p>"}]
         * remark : []
         */
        private  boolean isTrueOrFalse;
        private String id;
        private String cmStruId;
        private int cmContType;
        private String contName;
        private String imgUri;
        private String cmFlId;
        private String cmFsId;
        private String link;
        private String contAbs;
        private String cont;
        private String source;
        private String contLabel;
        private String contentParentId;
        private String contentChildrenId;
        private String createTime;
        private String imgUrl;
        private String remark;
        private List<AudioListListBean> audioListList;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCmStruId() {
            return cmStruId;
        }

        public void setCmStruId(String cmStruId) {
            this.cmStruId = cmStruId;
        }

        public int getCmContType() {
            return cmContType;
        }

        public void setCmContType(int cmContType) {
            this.cmContType = cmContType;
        }

        public String getContName() {
            return contName;
        }

        public void setContName(String contName) {
            this.contName = contName;
        }

        public String getImgUri() {
            return imgUri;
        }

        public void setImgUri(String imgUri) {
            this.imgUri = imgUri;
        }

        public String getCmFlId() {
            return cmFlId;
        }

        public void setCmFlId(String cmFlId) {
            this.cmFlId = cmFlId;
        }

        public String getCmFsId() {
            return cmFsId;
        }

        public void setCmFsId(String cmFsId) {
            this.cmFsId = cmFsId;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getContAbs() {
            return contAbs;
        }

        public void setContAbs(String contAbs) {
            this.contAbs = contAbs;
        }

        public String getCont() {
            return cont;
        }

        public void setCont(String cont) {
            this.cont = cont;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getContLabel() {
            return contLabel;
        }

        public void setContLabel(String contLabel) {
            this.contLabel = contLabel;
        }

        public String getContentParentId() {
            return contentParentId;
        }

        public void setContentParentId(String contentParentId) {
            this.contentParentId = contentParentId;
        }

        public String getContentChildrenId() {
            return contentChildrenId;
        }

        public void setContentChildrenId(String contentChildrenId) {
            this.contentChildrenId = contentChildrenId;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public List<AudioListListBean> getAudioListList() {
            return audioListList;
        }

        public void setAudioListList(List<AudioListListBean> audioListList) {
            this.audioListList = audioListList;
        }

        public static class AudioListListBean {
            /**
             * id : 879676418273837056
             * contId : 879676418244476928
             * sort : 1
             * audioUrl : http://cdlscmsaudio.oss-cn-huhehaote-nebula-1.aliyuncs.com/ea0c43f0fb1a46639244799c542e9839.mp3?Expires=1702884930&OSSAccessKeyId=LTAI5tE8k22tASfQeMbdKwo6&Signature=%2B7CrMhk3XU%2BVPLSo9CbcU%2B2BQic%3D
             * contTitle : 朴素归因理论
             * audioTimeLength : 77.80
             * contText : 朴素归因理论<p>1958年，海德在他的著作《人际关系心理学》中，从通俗心理学的角度提出了归因理论，该理论主要解决的是日常生活中人们如何找出事件的原因。海德认为人有二种强烈的动机：一是形成对周围环境一贯性理解的需要；二是控制环境的需要。为了满足这两种需要，普通人必须要对他人的行为进行归因，并且经过归因来预测他人的行为，唯有如此才有可能满足&ldquo;理解环境和控制环境&rdquo;的需要。</p>
             <p>海德还指出，在归因的时候，人们经常使用两个原则：</p>
             <p>一是共变原则（Principle of covariation），它是指某个特定的原因在许多不同的情境下和某个特定结果相联系，该原因不存在时，结果也不出现，我们就可以把结果归于该原因，这就是共变原则。</p>
             <p>二是排除原则，它是指如果内外因某一方面的原因足以解释事件，我们就可以排除另一方面的归因。</p>
             <p>&nbsp;</p>
             <p>&nbsp;</p>
             <p>&nbsp;</p>
             */

            private String id;
            private String contId;
            private int sort;
            private String audioUrl;
            private String contTitle;
            private String audioTimeLength;
            private String contText;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getContId() {
                return contId;
            }

            public void setContId(String contId) {
                this.contId = contId;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public String getAudioUrl() {
                return audioUrl;
            }

            public void setAudioUrl(String audioUrl) {
                this.audioUrl = audioUrl;
            }

            public String getContTitle() {
                return contTitle;
            }

            public void setContTitle(String contTitle) {
                this.contTitle = contTitle;
            }

            public String getAudioTimeLength() {
                return audioTimeLength;
            }

            public void setAudioTimeLength(String audioTimeLength) {
                this.audioTimeLength = audioTimeLength;
            }

            public String getContText() {
                return contText;
            }

            public void setContText(String contText) {
                this.contText = contText;
            }
        }
    }
}
