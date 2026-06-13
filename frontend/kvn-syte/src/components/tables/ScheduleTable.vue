<template>
    <div class="ui text container">
        <h2 class="ui header">
            <div class="content">
                Расписание игр сезона
            </div>
        </h2>
    </div>
    <div class="ui hidden divider"></div>
    <div class="ui input">
        <input type="text" name="name" v-model="tableTitle" placeholder="Название таблицы">
    </div>
    <table class="ui table">
        <thead>
            <tr>
                <th class="center aligned">Название игры</th>
                <th class="center aligned">Расписание</th>
                <th class="one wide"></th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="(game, i) in games" :key="i" @mouseover="game.isVisible = true" @mouseleave="game.isVisible = false">
                <td>
                    <div class="ui fluid input">
                        <input type="text" name="gameName" v-model="game.gameName">
                    </div>
                </td>
                <td>
                    <div class="ui fluid input">
                        <input type="date" name="gameDate" v-model="game.gameDate">
                    </div>
                </td>
                <td>
                    <div class="ui icon red button" @click="deleteRow(i)" v-if="game.isVisible">
                        <i class="x icon"></i>
                    </div>
                </td>
            </tr>
        </tbody>
    </table>
    <button class="ui primary button" @click="addRow">
        <i class="plus icon"></i> Добавить игру
    </button>
    <button class="ui green button" @click="saveChanges">
        <i class="check icon"></i> Сохранить изменения
    </button>
    <button class="ui button" @click="lookTable">
        <i class="eye icon"/> Предпросмотр таблицы
    </button>
    <TableWindow :tableId="-1" :table="table" v-if="isLook" @quit="isLook = false; table = {columns: [], rows: []}"/>
</template>

<script setup>
import router from '@/router';
import { ref } from 'vue';
import TableWindow from '../windows/TableWindow.vue';

const props = defineProps({
    table: {
        type: Object,
        required: true
    }
})

const games = ref([
    {
        gameName: 'Фестиваль',
        gameDate: '',
        isVisible: false
    },
    {
        gameName: 'Полуфинал',
        gameDate: '',
        isVisible: false
    },
    {
        gameName: 'Финал',
        gameDate: '',
        isVisible: false
    }
])
const tableTitle = ref("")
const table = ref({
    title: "",
    columns: [],
    rows: []
})
const isLook = ref(false)

if (props.table.games){
    games.value = JSON.parse(JSON.stringify(props.table.games))
    tableTitle.value = ''+props.table.title
}

function deleteRow(r){
    let gamesCopy = []
    for(let i = 0; i < games.value.length; i++){
        if(i != r){
            gamesCopy.push(games.value[i])
        }
    }
    games.value = gamesCopy
}

function addRow(){
    games.value.push({})
}

function saveChanges(){
    alert('Заглушка! Изменения сохранены!')
    router.push({name: 'Admin Home'})
}

function lookTable(){
    table.value.title = tableTitle.value
    table.value.columns = ["Название игры", "Расписание"]

    games.value.forEach(game => {
        table.value.rows.push([
            game.gameName, game.gameDate
        ])
    })

    isLook.value = true
}
</script>