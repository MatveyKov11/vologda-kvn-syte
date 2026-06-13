<template>
    <div class="back">
        <div class="window">
            <div class="ui buttons" style="position: absolute; top: 5px; right: 5px; z-index: 997;">
                <div class="ui icon button" @click="$emit('quit')">
                    <i class="x icon"/>
                </div>
            </div>
            <div class="ui segment" v-for="(el, i) in list" :key="i">
                {{ el.title }}: {{ el.type }}
            </div>
            <div class="ui clearing divider"/>
            <button class = "ui button" @click="$emit('quit')">Выйти</button>
        </div>
    </div>
</template>

<script setup>
import { ref } from 'vue';


const list = ref([
    {
        title: 'table1',
        type: 'reward'
    },
    {
        title: 'table2',
        type: 'score'
    },
    {
        title: 'table3',
        type: 'own'
    },
    {
        title: 'table4',
        type: 'team'
    },
    {
        title: 'table5',
        type: 'contest'
    }
])

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