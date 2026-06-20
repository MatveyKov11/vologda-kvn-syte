<template>
    <div class="ui container">
        <button class="ui button" @click="list = true" v-if="style.empty">
            <i class="edit icon"/> Открыть готовый стиль
        </button>
        <button class="ui button" @click="style = {empty: true}" v-else>
            <i class="plus icon"/> Создать новый стиль
        </button>
        <div class="ui divider"/>
        <div class="ui input">
            <input type="text" name="name" v-model="name" placeholder="Название стиля...">
        </div>
        <div class="ui form">
            <div class="field">
                <input type="text" name="font" v-model="fontName" placeholder="Название шрифта...">
            </div>
            <div class="field">
                <input type="number" name="size" v-model="fontSize" placeholder="14">
            </div>
        </div>
        <h4 class="ui header">
            <div class="content">
                Цвета
            </div>
        </h4>
        <div class="ui segment" v-for="(col, i) in colors" :key="i">
            <h4 class="ui header">
                #{{ i+1 }}
            </h4>
            <table class="ui very basic table">
                <tbody><tr>
                    <td class="one wide">
                        <div :style="circleStyle(col)"/>
                    </td>
                    <td class="left aligned eight wide">
                        #{{ toHex(col) }}
                    </td>
                    <td>
                        <div class="ui form">
                            <div class="field">
                                <label for="r">R:</label>
                                <input type="number" name="r" v-model="col.r" min="0" max="255">
                            </div>
                            <div class="field">
                                <label for="g">G:</label>
                                <input type="number" name="g" v-model="col.g" min="0" max="255">
                            </div>
                            <div class="field">
                                <label for="b">B:</label>
                                <input type="number" name="b" v-model="col.b" min="0" max="255">
                            </div>
                        </div>
                    </td>
                </tr></tbody>
            </table>
            <div class="ui right rail">
                <div class="ui buttons">
                    <div class="ui icon red button" @click="removeColor(i)">
                        <i class="x icon"/>
                    </div>
                </div>
            </div>
        </div>
        <button class="ui primary button" @click="addColor" v-if="colors.length < colorsNumber">
            <i class="plus icon"/> Добавить цвет
        </button>
        <StyleListWindow v-if="list" @quit="list = false" @select="(s) => list = false" />
    </div>
</template>

<script setup>
import { ref } from 'vue';
import StyleListWindow from './windows/lists/StyleListWindow.vue';

const name = ref('')
const fontName = ref('Times New Roman')
const fontSize = ref(14)
const colors = ref([
    {
        r: 122,
        g: 111,
        b: 111
    }
])
const colorsNumber = 4
const style = ref({
    empty: true
})
const list = ref(false)

const diam = 50
function circleStyle(col){
    return {
        width: diam + 'px',
        height: diam + 'px',
        borderRadius: diam / 2 + 'px',
        backgroundColor: 'rgb('+col.r+', '+col.g+', '+col.b+')',
        marginLeft: '20%',
        borderStyle: 'solid'
    }
}

const aCode = 'A'.charCodeAt()
function _toHex(x){
    let a = Math.floor(x / 16)
    let b = x % 16
    let aa = a.toString()
    let bb = b.toString()
    if(a > 9){
        aa = String.fromCharCode(aCode + a - 10)
    }
    if(b > 9){
        bb = String.fromCharCode(aCode + b - 10)
    }
    return aa+bb
}

function toHex(col){
    return _toHex(col.r)+_toHex(col.g)+_toHex(col.b)
}

function addColor(){
    colors.value.push({r:0, g: 255, b: 0})
}
function removeColor(r){
    let colorsCopy = []
    colors.value.forEach((col, i) => {
        if(i != r){
            colorsCopy.push(col)
        }
    })
    colors.value = colorsCopy
}
</script>