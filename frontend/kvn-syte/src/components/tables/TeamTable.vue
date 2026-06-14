<template>
    <div class="ui text container">
        <h2 class="ui header">
            <div class="content">
                Команды сезонов
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
                <th class="center aligned">Название команды</th>
                <th class="center aligned">Описание</th>
                <th class="one wide"></th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="(team, i) in teams" :key="i" @mouseover="team.isVisible = true" @mouseleave="team.isVisible = false">
                <td>
                    <div class="ui fluid input">
                        <input type="text" name="teamName" v-model="team.teamName">
                    </div>
                </td>
                <td>
                    <div class="ui fluid input">
                        <input type="text" name="capitanFio" v-model="team.description">
                    </div>
                </td>
                <td>
                    <div class="ui icon red button" @click="deleteRow(i)" v-if="team.isVisible">
                        <i class="x icon"/>
                    </div>
                </td>
            </tr>
        </tbody>
    </table>
    <button class="ui primary button" @click="addRow">
        <i class="plus icon"/> Добавить команду
    </button>
    <button class="ui green button" @click="saveChanges" v-if="props.table.teams">
        <i class="check icon"/> Сохранить изменения
    </button>
    <button class="ui green button" @click="saveTable" v-else>
        <i class="check icon"/> Сохранить таблицу
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

const teams = ref([
    {
        teamName: '35 Элемент',
        description: '---',
        isVisible: false
    },
    {
        teamName: 'Люди ФСИНем',
        description: '---',
        isVisible: false
    },
    {
        teamName: 'Хлорид Натрия',
        description: '---',
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

if (props.table.teams){
    teams.value = JSON.parse(JSON.stringify(props.table.teams))
    tableTitle.value = ''+props.table.title
}

function deleteRow(r){
    let teamsCopy = []
    for(let i = 0; i < teams.value.length; i++){
        if(i != r){
            teamsCopy.push(teams.value[i])
        }
    }
    teams.value = teamsCopy
}

function addRow(){
    teams.value.push({})
}

function fixTable(){
    table.value.title = tableTitle.value
    table.value.columns = ["Название команды", "Описание"]

    teams.value.forEach(team => {
        table.value.rows.push([
            team.teamName, team.description
        ])
    })
}

function saveChanges(){
    fixTable()

    alert('Заглушка! Изменения сохранены!')
    router.push({name: 'Admin Home'})
}

function saveTable(){
    fixTable()

    alert('Заглушка! Таблица сохранена!')
    router.push({name: 'Admin Home'})
}

function lookTable(){
    fixTable()

    isLook.value = true
}
</script>