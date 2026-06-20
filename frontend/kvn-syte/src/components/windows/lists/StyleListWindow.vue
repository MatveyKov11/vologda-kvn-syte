<template>
    <div class="back">
        <div class="window">
            <div class="ui buttons" style="position: absolute; top: 5px; right: 5px; z-index: 997;">
                <div class="ui icon button" @click="$emit('quit')">
                    <i class="x icon"/>
                </div>
            </div>
            <div class="ui icon input">
                <i class="search icon"/>
                <input type="text" placeholder="Поиск..." v-model="searchWord">
            </div>
            <div class="ui segment" v-for="(el, i) in listFiltered" :key="i" @click="$emit('select', el)">
                {{ el.title }}: {{ el.time }}
            </div>
            <div class="ui clearing divider"/>
            <button class = "ui button" @click="$emit('quit')">Выйти</button>
        </div>
    </div>
</template>

<script setup>
import { computed, ref } from 'vue';

const searchWord = ref("")
const list = ref([
    {
        title: 'С 23 февраля!',
        time: 'reward',
        id: 0
    },
    {
        title: 'С днём рождения!',
        time: 'schedule',
        id: 1
    },
    {
        title: 'Кубок работающей моложёжи!',
        time: 'own',
        id: 2
    }
])

let listFiltered = computed(() => list.value.filter(el => el.title.includes(searchWord.value)))
</script>

<style scoped>
.window {
  position: fixed;
  z-index: 999;
  top: 15%;
  left: 35%;
  width: 30%;
  height: 70%;
  background-color: #ffffff;
  border: 3px solid #000000;
  padding: 15px 15px;
  overflow: scroll;
}

.back {
    position: fixed;
    z-index: 998;
    top: 0%;
    left: 0%;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.5);
}
</style>